package designpatterns.db.seconddbconnection.singletondesgine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionSingleton {
    private static MySQLConnectionSingleton instance;
    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "bunty";

    private MySQLConnectionSingleton() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized MySQLConnectionSingleton getInstance() {
        if (instance == null) {
            instance = new MySQLConnectionSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
