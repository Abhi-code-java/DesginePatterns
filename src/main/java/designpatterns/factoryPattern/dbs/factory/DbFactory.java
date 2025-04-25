package designpatterns.factoryPattern.dbs.factory;


import designpatterns.factoryPattern.queries.FindAll;
import designpatterns.factoryPattern.queries.FindById;
import designpatterns.factoryPattern.queries.FindByName;

public interface DbFactory {
    FindAll getAll();
    FindByName findByName(String name);
    FindById findById(int id);
}
