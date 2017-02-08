package dao;

import models.Good;
import utills.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 33558 on 04.02.2017.
 */
public class GoodsDaoJdbcImpl extends DaoGoods {
    private MySqlConnector connector;
    private Good good;

    public GoodsDaoJdbcImpl() {
        connector = new MySqlConnector();
    }

    @Override
    public <T> void add(T t) {
        good = (Good) t;
        PreparedStatement statement;
        String query = "INSERT INTO goods (NAME_GOOD, DESCRIPTION_GOOD, PRICE_GOOD) VALUES (?,?,?);";
        try {
            statement = connector.getConnection().prepareStatement(query);
            statement.setString(1, good.getNameGood());
            statement.setString(2, good.getDescriptionGood());
            statement.setDouble(3, good.getPriceGood());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T getById(int id) {
        String query = "SELECT * FROM goods WHERE ID_GOOD ='" + id + "';";
        Good good = new Good();
        try {
            ResultSet resultSet = connector.getConnection().createStatement().executeQuery(query);
            while (resultSet.next()) {
                good.setIdGood(resultSet.getInt("ID_GOOD"));
                good.setNameGood(resultSet.getString("NAME_GOOD"));
                good.setDescriptionGood(resultSet.getString("DESCRIPTION_GOOD"));
                good.setPriceGood(resultSet.getDouble("PRICE_GOOD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T) good;
    }

    @Override
    public <T> void update(T t) {
        good = (Good) t;
        PreparedStatement statement;
        String query = "UPDATE goods SET NAME_GOOD=?, DESCRIPTION_GOOD=?,PRICE_GOOD=? WHERE ID_GOOD=?;";
        try {
            statement = connector.getConnection().prepareStatement(query);
            statement.setString(1, good.getNameGood());
            statement.setString(2, good.getDescriptionGood());
            statement.setDouble(3, good.getPriceGood());
            statement.setInt(4, good.getIdGood());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> void delete(T t) {
        good = (Good) t;
        String query = "DELETE FROM goods WHERE ID_GOOD=?";
        PreparedStatement statement;
        try {
            statement = connector.getConnection().prepareStatement(query);
            statement.setInt(1, good.getIdGood());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
