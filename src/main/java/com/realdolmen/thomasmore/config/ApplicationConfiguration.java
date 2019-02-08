package com.realdolmen.thomasmore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

/**
 * Created by JUZAU33 on 9/08/2017.
 */
@Configuration
@EnableJpaRepositories(
        basePackages = "com.realdolmen.thomasmore.repository"
        // .repository contains everything that communicates directly with the database!
)
@EnableTransactionManagement
public class ApplicationConfiguration {

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

//        MYSQL:
        /*
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3307/dbjavaadv");
        dataSource.setUsername("root");
        dataSource.setPassword("usbw");
        */
//        POSTGRESQL:
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("abmbvkcczyzasi");
        dataSource.setPassword("c9742db68a71e3109efb7a040070bf1862b7e40ed9a8e50533d6dfa5b14b65f7");
        dataSource.setUrl("postgres://abmbvkcczyzasi:c9742db68a71e3109efb7a040070bf1862b7e40ed9a8e50533d6dfa5b14b65f7@ec2-54-217-207-242.eu-west-1.compute.amazonaws.com:5432/d646l2ctoo4pqq");


        return dataSource;
    }

    @Bean
    public HibernateJpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPackagesToScan("com.realdolmen.thomasmore.domain");
        entityManager.setJpaVendorAdapter(jpaVendorAdapter());
        entityManager.setJpaProperties(jpaProperties());

        return entityManager;
    }

    @Bean
    public JpaTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        // the create-drop means create the table in the database when we run the project, delete the table when we stop the project!
        // create means create the tables, but let them be! After we restart the project, it is gonna automatically drop the table and create a new one!
        // update should be used after we have created the tables!!!

//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");

        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        return properties;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
