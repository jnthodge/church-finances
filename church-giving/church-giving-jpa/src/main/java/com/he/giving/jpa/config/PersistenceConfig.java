package com.he.giving.jpa.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.base.Preconditions;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages={"com.he.giving.jpa.repository"})
@PropertySource({"classpath:persistence-mysql.properties"})
@ComponentScan({"com.he.giving", "com.he.giving.jpa.repository"})
public class PersistenceConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource restDataSource() {
		final BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("jdbc.driverClassName")));
		dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("jdbc.url")));
		dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("jdbc.user")));
		dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("jdbc.pass")));
		
		return dataSource;
	}
	
	@Bean(destroyMethod = "close")
    DataSource dataSource(Environment env) {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
        dataSourceConfig.setDriverClassName(env.getRequiredProperty("db.driver"));
        dataSourceConfig.setJdbcUrl(env.getRequiredProperty("db.url"));
        dataSourceConfig.setUsername(env.getRequiredProperty("db.username"));
        dataSourceConfig.setPassword(env.getRequiredProperty("db.password"));
 
    }
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
	    lef.setPersistenceUnitName(PersistenceConstants.STOREHOUSE_PERSISTENCE_UNIT_NAME);
	    lef.setDataSource(this.restDataSource());
	    lef.setJpaVendorAdapter(getHibernateVendorAdapter());
	    String[] packages = env.getProperty("jpa.packages.to.scan").split(",");
	    lef.setPackagesToScan(packages);

	    Properties props = new Properties();
	    props.put("hibernate.show_sql", "true");
	    props.put("hibernate.format_sql", "true");
	    props.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
	    props.put("hibernate.connection.charSet", "UTF-8");
	    props.put("hibernate.current_session_context_class", "jta");
	    props.put("hibernate.archive.autodetection", "class");
	    props.put("hibernate.transaction.manager_lookup_class", "com.atomikos.icatch.jta.hibernate3.TransactionManagerLookup");
	    props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
	    props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	    lef.setJpaProperties(props);

	    lef.afterPropertiesSet();

	    return lef.getObject();
	}
	
	public JpaVendorAdapter getHibernateVendorAdapter() {
		JpaVendorAdapter hibernateVendorAdapter = new HibernateJpaVendorAdapter();
		return hibernateVendorAdapter;
	}
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(restDataSource());
		sessionFactory.setPackagesToScan(new String[] {"com.he"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(final SessionFactory sessionFactory) {
		final HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		
		return txManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	final Properties hibernateProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto",  env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return hibernateProperties;
	}
	
	
}
