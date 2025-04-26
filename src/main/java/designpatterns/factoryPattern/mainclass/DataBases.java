package designpatterns.factoryPattern.mainclass;


import designpatterns.factoryPattern.dbs.concrete_factory.DbFactory;
import designpatterns.factoryPattern.enumfactory.EnumFactory;
import designpatterns.factoryPattern.enums.EnumDatabase;


public class DataBases {
    private EnumDatabase enumDatabase;

    public DataBases(EnumDatabase enumDatabase) {
        this.enumDatabase = enumDatabase;
    }
    public void DataBaseRule(){
        System.out.println("rule no 1 for database ");
    }
    public void DataBaseRule2(){
        System.out.println("rule no 2 for database ");
    }
    public DbFactory createDbFactory(){
        return new EnumFactory().createEnumFactory(enumDatabase);
    }
}
