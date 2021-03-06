package net.wei.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration//annotated that this class could configure a bean that would be manage by spring framework
@ComponentScan(basePackages={"net.wei.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernatgeConfig {
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "192847";
	
	@Bean("dataSource")
	public DataSource getDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
	//session factory bean
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource){
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.wei.shoppingbackend.dto");		
		return builder.buildSessionFactory();
	}

	//All the hibernate properties will be returned in this method
	public Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");		
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("javax.persistence.validation.mode", "none");
		return properties;
	}
	
	//hibernate transaction manager bean	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
}
