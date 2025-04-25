package designpatterns.db.connectionservice;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import designpatterns.db.enums.Db_connection_enums;

import java.sql.SQLException;

public class MongoDbService implements ChooseDb {
    @Override
    public void CreateConnection(Db_connection_enums enums) throws SQLException {
        if (enums != Db_connection_enums.MONGODB) {
            throw new IllegalArgumentException("Invalid DB enum for MongoDB service");
        }

        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase db = mongoClient.getDatabase("mydb");
            System.out.println("✅ MongoDB Connection Established to: " + db.getName());
        } catch (Exception e) {
            System.out.println("❌ MongoDB Connection Error: " + e.getMessage());
        }

    }
}
