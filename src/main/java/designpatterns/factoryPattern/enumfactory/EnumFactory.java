package designpatterns.factoryPattern.enumfactory;


import designpatterns.factoryPattern.dbs.concrete_factory.DbFactory;
import designpatterns.factoryPattern.dbs.concrete_factory.MySQLFactory;
import designpatterns.factoryPattern.dbs.concrete_factory.PostGresqlFactory;
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
