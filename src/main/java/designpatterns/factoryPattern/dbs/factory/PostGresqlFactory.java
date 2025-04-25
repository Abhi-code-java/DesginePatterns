package designpatterns.factoryPattern.dbs.factory;


import designpatterns.factoryPattern.dbs.postgres.PostGesFindById;
import designpatterns.factoryPattern.dbs.postgres.PostGresFindAll;
import designpatterns.factoryPattern.dbs.postgres.PostGresFindByName;
import designpatterns.factoryPattern.queries.FindAll;
import designpatterns.factoryPattern.queries.FindById;
import designpatterns.factoryPattern.queries.FindByName;

public class PostGresqlFactory implements DbFactory{
    @Override
    public FindAll getAll() {
        return new PostGresFindAll();
    }

    @Override
    public FindByName findByName(String name) {
        return new PostGresFindByName();
    }

    @Override
    public FindById findById(int id) {
        return new PostGesFindById();
    }
}
