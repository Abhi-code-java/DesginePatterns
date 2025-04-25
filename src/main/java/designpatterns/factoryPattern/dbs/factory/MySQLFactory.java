package designpatterns.factoryPattern.dbs.factory;


import designpatterns.factoryPattern.dbs.mysql.MySqlDatabaseFindByName;
import designpatterns.factoryPattern.dbs.mysql.MysqlFIndById;
import designpatterns.factoryPattern.dbs.mysql.MysqlFindAll;
import designpatterns.factoryPattern.queries.FindAll;
import designpatterns.factoryPattern.queries.FindById;
import designpatterns.factoryPattern.queries.FindByName;

public class MySQLFactory implements DbFactory{
    @Override
    public FindAll getAll() {
        return new MysqlFindAll();
    }

    @Override
    public FindByName findByName(String name) {
        return new MySqlDatabaseFindByName();
    }

    @Override
    public FindById findById(int id) {
        return new MysqlFIndById();
    }
}
