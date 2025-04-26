package designpatterns.factoryPattern.dbs.concrete_factory;



import designpatterns.factoryPattern.dbs.operations.postgres.PostGesFindById;
import designpatterns.factoryPattern.dbs.operations.postgres.PostGresFindAll;
import designpatterns.factoryPattern.dbs.operations.postgres.PostGresFindByName;
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
