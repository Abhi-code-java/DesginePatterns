package designpatterns.factoryPattern.queries;

public interface QueryAbstractFactory {
    void FindByName(String name);
    void FindById(int id);
    void FindAll();
}
