package designpatterns.factoryPattern.dbs.operations.mysql;


import designpatterns.factoryPattern.queries.FindByName;
//MySQLFactory and PostGresqlFactory (Concrete Factories)
//They implement DbFactory, meaning:
//
//If the user selects MySQL, use MySQL-specific classes.
//
//If the user selects Postgres, use Postgres-specific classes.
public class MySqlDatabaseFindByName implements FindByName {

}
