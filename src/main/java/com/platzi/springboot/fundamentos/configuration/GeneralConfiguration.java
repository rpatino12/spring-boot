package com.platzi.springboot.fundamentos.configuration;

import com.platzi.springboot.fundamentos.bean.MyBeanProperties;
import com.platzi.springboot.fundamentos.bean.MyBeanPropertiesImpl;
import com.platzi.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(UserPojo.class) // To set the UserPojo class as a representation of properties
public class GeneralConfiguration {
    // This way we can map the properties stored in the application.properties file
    @Value("${value.name}")
    private String name;

    @Value("${value.lastName}")
    private String lastName;

    @Value("${value.random}")
    private String random;

    // Now that we have the properties in attributes we need a bean to work with them
    @Bean
    public MyBeanProperties myBeanProperties(){
        return new MyBeanPropertiesImpl(name, lastName, random);
    }

    // We can create a bean to set the database connection and inject the dependency
    // Note: If you want to see the database console using h2-console (go to http://localhost:8081/app/h2-console/)
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        return dataSourceBuilder.driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:testdb")
                .username("sa")
                .password("")
                .build();
    }
}
