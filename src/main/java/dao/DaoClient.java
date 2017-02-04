package dao;

import models.Client;
import utills.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by 33558 on 04.02.2017.
 */
public class DaoClient {

    private MySqlConnector connector;

    public DaoClient() {
        connector = new MySqlConnector();
    }

    public void addClient(Client client) {
        PreparedStatement statement;
        String query = "INSERT INTO apartments (REGION, ADDRESS, SQUARE, ROOMS, PRICE) VALUES (?,?,?,?,?)";
        try {
            statement = connector.getConnection().prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
