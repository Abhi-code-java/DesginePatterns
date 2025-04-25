package designpatterns.db.connectionservice;

import designpatterns.db.enums.Db_connection_enums;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlService implements ChooseDb {
    @Override
    public void CreateConnection(Db_connection_enums enums) throws SQLException {
        if (enums != Db_connection_enums.MySQL) {
            throw new IllegalArgumentException("Invalid DB enum for MySQL service");
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "bunty";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("✅ MySQL Connection Established");
            // You can now use this connection
        } catch (SQLException e) {
            System.out.println("❌ Failed to connect to MySQL: " + e.getMessage());
            throw e;
        }
    }
}
