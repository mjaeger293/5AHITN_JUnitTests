import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DatabaseTest {

    static Connection db;

    @BeforeAll
    static void initDb() {
        db = MySQLInstance.getInstance();
    }

    static void reconnect() {
        db = MySQLInstance.getInstance();
    }

    @Test
    @Order(1)
    void createDatabase() {
        Assertions.assertDoesNotThrow(() -> {
            db.prepareStatement("CREATE DATABASE `junit-test`").executeUpdate();
            reconnect();
        });
    }

    @Test
    @Order(2)
    void createTable() {
        Assertions.assertDoesNotThrow(() -> {
            db.prepareStatement("CREATE TABLE `junit-test`.fraction (dividend INT, divisor INT)").executeUpdate();
        });
    }

    @Test
    @Order(3)
    void insert() {
        Assertions.assertDoesNotThrow(() -> {
            db.prepareStatement("INSERT INTO `junit-test`.fraction (dividend, divisor) VALUES (10, 5)").executeUpdate();
        });
    }

    @Test
    @Order(4)
    void select() {
        Assertions.assertDoesNotThrow(() -> {
            ResultSet result = db.prepareStatement("SELECT * FROM `junit-test`.fraction LIMIT 1").executeQuery();

            if (result.next()) {
                Assertions.assertEquals(10, result.getInt("dividend"));
                Assertions.assertEquals(5, result.getInt("divisor"));
            } else {
                Assertions.fail();
            }
        });
    }
}