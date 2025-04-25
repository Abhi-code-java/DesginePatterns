package designpatterns.db.connectionservice;

import designpatterns.db.enums.Db_connection_enums;

import java.sql.SQLException;

public interface ChooseDb {
    public void CreateConnection(Db_connection_enums enums) throws SQLException;
}
