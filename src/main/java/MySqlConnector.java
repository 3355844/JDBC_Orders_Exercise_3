import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 33558 on 03.02.2017.
 */
public class MySqlConnector {
    private Connection connection;

    public MySqlConnector() {
        MySqlProperties properties = new MySqlProperties();
        try {
            connection = DriverManager.getConnection(properties.getUrl(), properties.getUser(), properties.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
