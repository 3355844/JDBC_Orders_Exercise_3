package dao;

import models.Client;
import models.Good;
import utills.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 33558 on 04.02.2017.
 */
public class DaoGoods {
    private MySqlConnector connector;

    public DaoGoods() {
        connector = new MySqlConnector();
    }

    public void addGoodToDB(Good good) {
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

    public Good getGoodByID(int id) {
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
        return good;
    }
}
