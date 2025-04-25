package designpatterns.db.seconddbconnection.singletondesgine;

import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class MySQLConnectionSingletonTest {

    @Test
    public void testSingletonInstance() {
        MySQLConnectionSingleton conn1 = MySQLConnectionSingleton.getInstance();
        MySQLConnectionSingleton conn2 = MySQLConnectionSingleton.getInstance();

        assertSame(conn1, conn2);
    }

    @Test
    public void testMySQLConnectionIsValid() throws Exception {
        Connection connection = MySQLConnectionSingleton.getInstance().getConnection();
        assertNotNull(connection);
        assertFalse(connection.isClosed());
    }
    @Test
    public void testMySQLQuery() throws Exception {
        Connection connection = MySQLConnectionSingleton.getInstance().getConnection();
        var rs = connection.createStatement().executeQuery("SELECT 1");
        assertTrue(rs.next());
        assertEquals(1, rs.getInt(1));
    }
}