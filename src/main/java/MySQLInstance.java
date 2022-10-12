import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLInstance {

    private MySQLInstance() {
    }

    private static Connection connection = null;

    public synchronized static Connection getInstance() {
        if (connection == null) {
            try {
                // erzeuge neue Verbinung zur Datenbank
                connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "junit-test", "junit-test");
            } catch (SQLException throwables) {
            }
        }
        return connection;
    }
}
