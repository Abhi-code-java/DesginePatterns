package designpatterns.db.connectionservice;

import designpatterns.db.enums.Db_connection_enums;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2DataBaseService implements ChooseDb {
    @Override
    public void CreateConnection(Db_connection_enums enums) throws SQLException {
        if (enums != Db_connection_enums.H2) {
            throw new IllegalArgumentException("Invalid DB enum for H2 service");
        }

        String url = "jdbc:h2:mem:testdb";
        String username = "sa";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("✅ H2 Connection Established");
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to H2: " + e.getMessage());
            throw e;
        }

    }
}
