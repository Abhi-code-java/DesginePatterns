package designpatterns.db.dbfactory;

import designpatterns.db.enums.Db_connection_enums;

import java.sql.SQLException;

public class ChooseDatabase {
    private final DatabaseFactory factory = new DatabaseFactory();

    public void connectToDatabase(Db_connection_enums enums) throws SQLException {
        factory.startConnection(enums);
    }
    public void getConnection(String conn) throws SQLException {
        factory.startConnection(Db_connection_enums.valueOf(conn));
    }
}
