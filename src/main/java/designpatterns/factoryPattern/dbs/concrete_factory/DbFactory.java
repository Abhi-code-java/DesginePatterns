package designpatterns.factoryPattern.dbs.concrete_factory;


import designpatterns.factoryPattern.queries.FindAll;
import designpatterns.factoryPattern.queries.FindById;
import designpatterns.factoryPattern.queries.FindByName;
// MAIN FACTORY INTERFACE
//t says any database factory (like MySQL or PostgreSQL) must know how to:
//
//        getAll() → to find all records.
//
//        findByName(String name) → to find by name.
//
//        findById(int id) → to find by ID.
public interface DbFactory {
    FindAll getAll();
    FindByName findByName(String name);
    FindById findById(int id);
}
