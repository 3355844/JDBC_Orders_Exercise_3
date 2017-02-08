package dao;

import models.Client;
import utills.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 33558 on 04.02.2017.
 */
public class ClientDaoJdbcImpl extends DaoClient {

    private MySqlConnector connector;
    private Client client;

    public ClientDaoJdbcImpl() {
        connector = new MySqlConnector();
    }

    @Override
    public <T> void add(T t) {
        client = (Client) t;
        PreparedStatement statement;
        String query = "INSERT INTO clients (NAME_CLIENT, ADDRESS_CLIENT, PHONE_CLIENT) VALUES (?,?,?);";
        try {
            statement = connector.getConnection().prepareStatement(query);
            statement.setString(1, client.getNameClient());
            statement.setString(2, client.getAddressClient());
            statement.setString(3, client.getPhoneClient());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T getById(int id) {
        String query = "SELECT * FROM clients WHERE ID_CLIENT ='" + id + "';";
        Client client = new Client();
        try {
            ResultSet resultSet = connector.getConnection().createStatement().executeQuery(query);
            while (resultSet.next()) {
                client.setIdClient(resultSet.getInt("ID_CLIENT"));
                client.setNameClient(resultSet.getString("NAME_CLIENT"));
                client.setAddressClient(resultSet.getString("ADDRESS_CLIENT"));
                client.setPhoneClient(resultSet.getString("PHONE_CLIENT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T) client;
    }

    @Override
    public <T> void update(T t) {
        client = (Client) t;
        PreparedStatement statement;
        String query = "UPDATE clients SET NAME_CLIENT=?, ADDRESS_CLIENT=?,PHONE_CLIENT=? WHERE ID_CLIENT=?;";
        try {
            statement = connector.getConnection().prepareStatement(query);
            statement.setString(1, client.getNameClient());
            statement.setString(2, client.getAddressClient());
            statement.setString(3, client.getPhoneClient());
            statement.setInt(4, client.getIdClient());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> void delete(T t) {
        client = (Client) t;
        String query = "DELETE FROM clients WHERE ID_CLIENT=?";
        PreparedStatement statement;
        try {
            statement = connector.getConnection().prepareStatement(query);
            statement.setInt(1, client.getIdClient());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
