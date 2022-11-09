import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DatabaseTest {

    static Connection db;

    @BeforeAll
    static void initDb() {
        db = MySQLInstance.getInstance();
    }

    private Connection connect(String db) {
        Connection conn = null;

        try {
            if (db.length() > 0) {
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" + db, "root", "root");
            } else {
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "root");
            }
        } catch(Exception e) {

        }

        return conn;
    }

    @Test
    @Order(1)
    void connectToDatabase() {
        /*Assertions.assertDoesNotThrow(() -> {
            db.prepareStatement("CREATE DATABASE `junit-test`").executeUpdate();
            db.prepareStatement("USE `junit-test`").execute();
        });*/

        Assertions.assertDoesNotThrow(new ThrowingSupplier<Connection>() {
            @Override
            public Connection get() throws Throwable {
                return connect("");
            }
        });
    }

    @Test
    @Order(2)
    void createDatabase() {
        /*Assertions.assertDoesNotThrow(() -> {
            db.prepareStatement("CREATE DATABASE `junit-test`").executeUpdate();
            db.prepareStatement("USE `junit-test`").execute();
        });*/

        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("");

            Statement s = c.createStatement();

            s.executeUpdate("CREATE DATABASE testdb");

            s.execute("USE `testdb`");

            s.close();
            c.close();
        });
    }

    @Test
    @Order(3)
    void createTable() {
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("testdb");

            c.prepareStatement("CREATE TABLE fraction (dividend INT, divisor INT)").executeUpdate();
        });
    }

    @Test
    @Order(4)
    void insert() {
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("testdb");

            c.prepareStatement("INSERT INTO fraction (dividend, divisor) VALUES (10, 5)").executeUpdate();
        });
    }

    @Test
    @Order(5)
    void select() {
        Assertions.assertDoesNotThrow(() -> {
            Connection c = connect("testdb");

            ResultSet result = db.prepareStatement("SELECT * FROM fraction LIMIT 1").executeQuery();

            if (result.next()) {
                Assertions.assertEquals(10, result.getInt("dividend"));
                Assertions.assertEquals(5, result.getInt("divisor"));
            } else {
                Assertions.fail();
            }
        });
    }
}