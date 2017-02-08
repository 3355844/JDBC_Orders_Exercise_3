package dao;

import models.Order;
import utills.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 33558 on 04.02.2017.
 */
public class OrderDaoJdbcImpl extends DaoOrder {

    private MySqlConnector connector;
    private Order order;

    public OrderDaoJdbcImpl() {
        connector = new MySqlConnector();
    }

    @Override
    public <T> void add(T t) {
        order = (Order) t;
        PreparedStatement statement;
        String query = "INSERT INTO orders (ID_CLIENT, ID_GOOD) VALUES (?,?)";
        try {
            statement = connector.getConnection().prepareStatement(query);
            statement.setInt(1, order.getIdClient());
            statement.setInt(2, order.getIdGoods());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T getById(int id) {
        String query = "SELECT * FROM orders WHERE ID_ORDER ='" + id + "';";
        Order order = new Order();
        try {
            ResultSet resultSet = connector.getConnection().createStatement().executeQuery(query);
            while (resultSet.next()) {
                order.setIdOrder(resultSet.getInt("ID_ORDER"));
                order.setIdClient(resultSet.getInt("ID_CLIENT"));
                order.setIdGoods(resultSet.getInt("ID_GOOD"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (T) order;
    }

    @Override
    public <T> void update(T t) {
        order = (Order) t;
        PreparedStatement statement;
        String query = "UPDATE orders SET ID_CLIENT=?, ID_GOOD=? WHERE ID_ORDER=?;";
        try {
            statement = connector.getConnection().prepareStatement(query);
            statement.setInt(1, order.getIdClient());
            statement.setInt(2, order.getIdGoods());
            statement.setInt(3, order.getIdOrder());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> void delete(T t) {
        order = (Order) t;
        String query = "DELETE FROM orders WHERE ID_ORDER=?";
        PreparedStatement statement;
        try {
            statement = connector.getConnection().prepareStatement(query);
            statement.setInt(1, order.getIdOrder());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
