package designpatterns.db.seconddbconnection.db_configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryBean",
        basePackages = "designpatterns.customer.repos.mysql",
        transactionManagerRef = "transactionManager"
)

public class MysqlDatabaseConfig {
    @Autowired
    private Environment environment;
@Bean("mysql")
@Primary
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("spring.datasource.jdbcUrl"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username"));
        dataSource.setPassword(environment.getProperty( "spring.datasource.password"));
        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("spring.datasource.driver-class-name")));
        return dataSource;
    }

    @Bean(name = "entityManagerFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter adaptor=new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(adaptor);

        bean.setDataSource(dataSource());

        Map<String,String>map=new HashMap<>();
        map.put("spring.jpa.properties.hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        map.put("spring.jpa.show-sql","true");
        map.put("hibernate.hbm2ddl.auto", "update");
        bean.setJpaPropertyMap(map);
        bean.setPackagesToScan("designpatterns.customer.entity");

        return bean;
    }
    @Bean(name ="transactionManager" )
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager manager=new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return manager;
    }
}
