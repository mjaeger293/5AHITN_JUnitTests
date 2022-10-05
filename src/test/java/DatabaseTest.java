import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

class DatabaseTest {

    @Test
    void createTable() throws SQLException {
        Connection connection = MySQLInstance.getInstance();

        connection.prepareStatement("CREATE TABLE fraction (dividend INT, divisor INT)").executeQuery();
    }
}