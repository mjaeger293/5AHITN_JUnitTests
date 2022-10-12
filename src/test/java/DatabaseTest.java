import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

class DatabaseTest {

    static Connection db;

    @BeforeAll
    static void initDb() {
        try {
            db = MySQLInstance.getInstance();
        } catch (Exception e) {
        }
    }

    @Test
    @Order(1)
    void createTable() {
        Assertions.assertDoesNotThrow(() -> {
            db.prepareStatement("CREATE TABLE mysql.fraction (dividend INT, divisor INT)").executeUpdate();

            db.prepareStatement("INSERT INTO mysql.fraction (dividend, divisor) VALUES (10, 5)").executeUpdate();

            ResultSet result = db.prepareStatement("SELECT * FROM mysql.fraction LIMIT 1").executeQuery();

            if (result.next()) {
                Assertions.assertEquals(10, result.getInt("dividend"));
                Assertions.assertEquals(5, result.getInt("divisor"));
            } else {
                Assertions.fail();
            }
        });
    }

    @Test
    @Order(2)
    void insert() {
        Assertions.assertDoesNotThrow(() -> {
            db.prepareStatement("INSERT INTO mysql.fraction (dividend, divisor) VALUES (10, 5)").executeUpdate();
        });
    }

    @Test
    @Order(3)
    void select() {
        Assertions.assertDoesNotThrow(() -> {
            ResultSet result = db.prepareStatement("SELECT * FROM mysql.fraction LIMIT 1").executeQuery();

            if (result.next()) {
                Assertions.assertEquals(10, result.getInt("dividend"));
                Assertions.assertEquals(5, result.getInt("divisor"));
            } else {
                Assertions.fail();
            }
        });
    }
}