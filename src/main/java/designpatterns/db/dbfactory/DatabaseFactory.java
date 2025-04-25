package designpatterns.db.dbfactory;

import designpatterns.db.connectionservice.H2DataBaseService;
import designpatterns.db.connectionservice.MongoDbService;
import designpatterns.db.connectionservice.MySqlService;
import designpatterns.db.connectionservice.PostgreService;
import designpatterns.db.connectionservice.ChooseDb;
import designpatterns.db.enums.Db_connection_enums;

import java.sql.SQLException;

public class DatabaseFactory {
    public ChooseDb getDatabaseService(Db_connection_enums enums) {
        switch (enums) {
            case MySQL:
                return new MySqlService();

            case MONGODB:
                return new MongoDbService();

                case H2:
                return new H2DataBaseService();

                case POSTGRES:
                return new PostgreService();

            default:
                throw new IllegalArgumentException("No valid database selected.");
        }
    }

    public void startConnection(Db_connection_enums enums) throws SQLException {
        ChooseDb service = getDatabaseService(enums);
        service.CreateConnection(enums);
    }
}
