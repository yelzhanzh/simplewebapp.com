package com.simplewebapp.config;

import java.util.Properties;

import javax.activation.DataSource;
import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Created by Zhangariny on 07/07/2015.
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.simplewebapp")
public class DataBaseConfig {

  private static final String DATABASE_DRIVER = "db.driver";
  private static final String DATABASE_URL = "db.url";
  private static final String DATABASE_USERNAME = "db.username";
  private static final String DATABASE_PASSWORD = "db.password";

  private static final String HIBERNATE_DIALECT = "hibernate.dialect";
  private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
  private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

  @Resource
  private Environment environment;

  @Bean
  public DriverManagerDataSource dataSource() {
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
    driverManagerDataSource.setUrl(environment.getRequiredProperty(DATABASE_URL));
    driverManagerDataSource.setUsername(environment.getRequiredProperty(DATABASE_USERNAME));
    driverManagerDataSource.setPassword(environment.getRequiredProperty(DATABASE_PASSWORD));
    driverManagerDataSource.setDriverClassName(environment.getRequiredProperty(DATABASE_DRIVER));

    return driverManagerDataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource());
    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    entityManagerFactoryBean.setPackagesToScan(environment.getRequiredProperty(ENTITYMANAGER_PACKAGES_TO_SCAN));
    entityManagerFactoryBean.setJpaProperties(jpaProperties());

    return entityManagerFactoryBean;
  }

  private Properties jpaProperties() {
    Properties properties = new Properties();
    properties.put(HIBERNATE_DIALECT, environment.getRequiredProperty(HIBERNATE_DIALECT));
    properties.put(HIBERNATE_SHOW_SQL, environment.getRequiredProperty(HIBERNATE_SHOW_SQL));
    return properties;
  }

  @Bean
  public JpaTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }

}
