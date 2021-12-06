package it.unisa.advanced.dao;

import it.unisa.advanced.domain.Motivazione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ScanDAO {

    public static final String TABLE = "SCAN";
    private GreenPassDAO greenPassDAO;
    private Connection connection;

    public ScanDAO(String url, String dbName, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url + dbName, username, password);
            connection.setAutoCommit(true);
            this.greenPassDAO = new GreenPassDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ScanDAO(Connection connection) {
        this.connection = connection;
    }

    public List<ScanDTO> getAll() {
        List<ScanDTO> scans = new ArrayList<>();
        String query = String.format("SELECT * FROM %s;", TABLE);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ScanDTO gp = resultSetToDTO(rs);
                scans.add(gp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scans;
    }

    private ScanDTO resultSetToDTO(ResultSet rs) throws SQLException {
        ScanDTO scan = new ScanDTO();
        String greenPassQR = rs.getString("greenPass");
        scan.setGreenPass(greenPassDAO.getByQrCode(greenPassQR));
        scan.setValido(rs.getBoolean("valido"));
        scan.setDataVerifica(rs.getDate("dataVerifica").toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());
        return scan;
    }

}
