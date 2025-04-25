package designpatterns.factoryPattern.enumfactory;


import designpatterns.factoryPattern.dbs.factory.DbFactory;
import designpatterns.factoryPattern.dbs.factory.MySQLFactory;
import designpatterns.factoryPattern.dbs.factory.PostGresqlFactory;
import designpatterns.factoryPattern.enums.EnumDatabase;

public class EnumFactory {
    public DbFactory createEnumFactory(EnumDatabase database){
        switch (database){
            case MYSQL:
                return new MySQLFactory();
            case POSTGRES:
                return new PostGresqlFactory();
            default:
                throw new IllegalArgumentException("NO DATABASE AVALAILABLE");
        }
    }
}
