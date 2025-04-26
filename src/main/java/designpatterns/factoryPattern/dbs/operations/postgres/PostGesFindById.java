package designpatterns.factoryPattern.dbs.operations.postgres;


import designpatterns.factoryPattern.queries.FindById;
//MySQLFactory and PostGresqlFactory (Concrete Factories)
//They implement DbFactory, meaning:
//
//If the user selects MySQL, use MySQL-specific classes.
//
//If the user selects Postgres, use Postgres-specific classes.
public class PostGesFindById implements FindById {
}
