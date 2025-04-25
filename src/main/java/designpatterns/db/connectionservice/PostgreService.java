package designpatterns.db.connectionservice;

import designpatterns.db.enums.Db_connection_enums;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreService implements ChooseDb {
    @Override
    public void CreateConnection(Db_connection_enums enums) throws SQLException {
        if (enums != Db_connection_enums.POSTGRES) {
            throw new IllegalArgumentException("Invalid DB enum for PostGres service");
        }

        String url = "jdbc:postgresql://localhost:5432/mydb";
        String username = "root";
        String password = "bunty";
        String drivers="org.postgresql,Driver";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("✅ POSTGRES Connection Established");
            // You can now use this connection
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to POSTGRES: " + e.getMessage());
            throw e;
        }
    }
}
