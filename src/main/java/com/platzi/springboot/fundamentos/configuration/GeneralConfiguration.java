package com.platzi.springboot.fundamentos.configuration;

import com.platzi.springboot.fundamentos.bean.MyBeanProperties;
import com.platzi.springboot.fundamentos.bean.MyBeanPropertiesImpl;
import com.platzi.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
