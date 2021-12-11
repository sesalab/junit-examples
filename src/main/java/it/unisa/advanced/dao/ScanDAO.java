package it.unisa.advanced.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ScanDAO {

    public static final String TABLE = "SCAN";
    private Connection connection;

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

    public void insertScan(ScanDTO scan) {
        String query = String.format("INSERT INTO %s (greenPass, dataVerifica, valido) VALUES (?, ?, ?);", TABLE);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, scan.getGreenPass());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(scan.getDataVerifica()));
            preparedStatement.setBoolean(3, scan.isValido());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private ScanDTO resultSetToDTO(ResultSet rs) throws SQLException {
        ScanDTO scan = new ScanDTO();
        scan.setGreenPass(rs.getString("greenPass"));
        scan.setValido(rs.getBoolean("valido"));
        scan.setDataVerifica(rs.getTimestamp("dataVerifica").toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());
        return scan;
    }

}
