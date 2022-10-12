import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

class DatabaseTest {

    @Test
    void createTable() throws SQLException {
        Connection connection = MySQLInstance.getInstance();
        Assertions.assertNotEquals(null, connection);

        connection.prepareStatement("CREATE TABLE fraction (dividend INT, divisor INT)").execute();
    }

    @Test
    void insert() throws SQLException {
        Connection connection = MySQLInstance.getInstance();
        Assertions.assertNotEquals(null, connection);

        connection.prepareStatement("INSERT INTO fraction (dividend, divisor) VALUES (10, 5)").executeUpdate();
    }

    @Test
    void select() throws SQLException {
        Connection connection = MySQLInstance.getInstance();
        Assertions.assertNotEquals(null, connection);

        ResultSet result = connection.prepareStatement("SELECT * FROM fraction LIMIT 1").executeQuery();

        if (result.next()) {
            Assertions.assertEquals(10, result.getInt("dividend"));
            Assertions.assertEquals(5, result.getInt("divisor"));
        }
    }
}