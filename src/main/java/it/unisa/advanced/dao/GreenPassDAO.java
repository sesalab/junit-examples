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

public class GreenPassDAO {

    public static final String TABLE = "GREEN_PASS";
    private Connection connection;

    public GreenPassDAO(String url, String dbName, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(url + dbName, username, password);
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public GreenPassDAO(Connection connection) {
        this.connection = connection;
    }

    public List<GreenPassDTO> getAll() {
        List<GreenPassDTO> greenPasses = new ArrayList<>();
        String query = String.format("SELECT * FROM %s;", TABLE);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                GreenPassDTO gp = resultSetToDTO(rs);
                greenPasses.add(gp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return greenPasses;
    }

    public GreenPassDTO getByQrCode(String qrCode) {
        String query = String.format("SELECT * FROM %s WHERE qrCode=?;", TABLE);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, qrCode);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return resultSetToDTO(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private GreenPassDTO resultSetToDTO(ResultSet rs) throws SQLException {
        GreenPassDTO gp = new GreenPassDTO();
        gp.setQrCode(rs.getString("qrCode"));
        gp.setNomeCompleto(rs.getString("nomeCompleto"));
        gp.setDataEmissione(rs.getDate("dataEmissione").toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime());
        gp.setMotivazione(Motivazione.valueOf(rs.getString("motivazione")));
        return gp;
    }

}
