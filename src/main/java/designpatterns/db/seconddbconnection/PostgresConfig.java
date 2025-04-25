package designpatterns.db.seconddbconnection;

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


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondEntityManagerFactoryBean",
        basePackages = "designpatterns.customer.repos.postgres",
        transactionManagerRef = "secondTransactionManager"
)

public class PostgresConfig {
    @Autowired
    private Environment environment;
    @Bean("postgres")
    @Primary
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("postgres.datasource.jdbcUrl"));
        dataSource.setUsername(environment.getProperty("postgres.datasource.username"));
        dataSource.setPassword(environment.getProperty( "postgres.datasource.password"));
        dataSource.setDriverClassName(environment.getProperty( "postgres.datasource.driver-class-name"));
        return dataSource;
    }

    @Bean(name = "secondEntityManagerFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter adaptor=new HibernateJpaVendorAdapter();
        bean.setJpaVendorAdapter(adaptor);

        Map<String,String> map=new HashMap<>();
        map.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        map.put("spring.jpa.show-sql","true");
        map.put("hibernate.hbm2ddl.auto","update");
        bean.setJpaPropertyMap(map);
        bean.setPackagesToScan("designpatterns.customer.prostEntity");
        bean.setDataSource(dataSource());
        return bean;
    }
    @Bean(name ="secondTransactionManager" )
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager manager=new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
        return manager;
    }
}
