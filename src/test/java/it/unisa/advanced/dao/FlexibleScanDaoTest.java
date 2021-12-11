package it.unisa.advanced.dao;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.SortedTable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Serve dipendenza dal vecchio junit, purtroppo, è un problema di DBUnit che dipende da una vecchia classe
public class FlexibleScanDaoTest {
    private static IDatabaseTester tester;
    private ScanDAO scanDAO;

    @BeforeAll
    static void setUpAll() throws ClassNotFoundException {
        // mem indica che il DB deve andare in memoria
        // test indica il nome del DB
        // DB_CLOSE_DELAY=-1 impone ad H2 di eliminare il DB solo quando il processo della JVM termina
        tester = new JdbcDatabaseTester(org.h2.Driver.class.getName(),
                "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;init=runscript from 'classpath:db/init/schema.sql'",
                "sa",
                ""
        );
        // Refresh permette di svuotare la cache dopo un modifica con setDataSet
        // DeleteAll ci svuota il DB manteneno lo schema
        tester.setSetUpOperation(DatabaseOperation.REFRESH);
        tester.setTearDownOperation(DatabaseOperation.DELETE_ALL);
    }

    private static void refreshDataSet(String filename) throws Exception {
        IDataSet initialState = new FlatXmlDataSetBuilder()
                .build(FlexibleScanDaoTest.class.getClassLoader().getResourceAsStream(filename));
        tester.setDataSet(initialState);
        tester.onSetup();
    }

    @BeforeEach
    public void setUp() throws Exception {
        // Prepara lo stato iniziale di default
        refreshDataSet("db/init/init.xml");
        scanDAO = new ScanDAO(tester.getConnection().getConnection());
    }

    @AfterEach
    public void tearDown() throws Exception {
        tester.onTearDown();
    }

    @Test
    public void testGetAll() throws Exception {
        // Prepara un stato iniziale diverso da quello di default
        refreshDataSet("db/init/testGetAll.xml");

        // Prepara output atteso
        ScanDTO scan1 = new ScanDTO();
        scan1.setGreenPass("wxyz");
        scan1.setValido(true);
        scan1.setDataVerifica(LocalDateTime.parse("2021-12-10 20:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ScanDTO scan2 = new ScanDTO();
        scan2.setGreenPass("wxyz");
        scan2.setValido(true);
        scan2.setDataVerifica(LocalDateTime.parse("2021-12-10 21:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        List<ScanDTO> expectedScans = new ArrayList<>();
        expectedScans.add(scan1);
        expectedScans.add(scan2);

        List<ScanDTO> actualScans = scanDAO.getAll();
        assertEquals(2, actualScans.size(), "Le tuple di SCAN recuperate non sono 2");
        assertArrayEquals(expectedScans.toArray(), actualScans.toArray(), "Le tuple di SCAN recuperate non sono identiche a attese");
    }

    @Test
    public void testInsertScan() throws Exception {
        // Prepara stato atteso
        ITable expectedTable = new FlatXmlDataSetBuilder()
                .build(FlexibleScanDaoTest.class.getClassLoader().getResourceAsStream("db/expected/testInsertScan.xml"))
                .getTable(ScanDAO.TABLE);

        ScanDTO scan = new ScanDTO();
        scan.setGreenPass("aaaa");
        scan.setValido(true);
        scan.setDataVerifica(LocalDateTime.parse("2021-12-10 21:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        scanDAO.insertScan(scan);

        // Per ottenere lo stato actual, non usare tester.getDataset() che, invece, restituisce quello assegnato con setDataSet()
        ITable actualTable = tester.getConnection().createDataSet().getTable(ScanDAO.TABLE);
        // Purtroppo l'equals di DBUnit è debole all'ordinamento, quindi dobbiamo risolverla così
        Assertion.assertEquals(new SortedTable(expectedTable), new SortedTable(actualTable));
    }
}
