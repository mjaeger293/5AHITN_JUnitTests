import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLInstance {

    static {
        try {
            String driver = "com.mysql.jdbc.Driver";

            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private MySQLInstance() {
    }

    private static Connection connection = null;

    public synchronized static Connection getInstance() {
        if (connection == null) {
            try {
                // erzeuge neue Verbinung zur Datenbank
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/junit-test?useSSL=false", "junit-test", "junit-test");
            } catch (SQLException throwables) {
            }
        }
        return connection;
    }
}