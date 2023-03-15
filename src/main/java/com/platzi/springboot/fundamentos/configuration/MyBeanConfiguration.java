package com.platzi.springboot.fundamentos.configuration;

import com.platzi.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// We have to use the Spring Boot annotation @Configuration to mark this class as a configuration for our beans
@Configuration
public class MyBeanConfiguration {

    // With this @Bean annotation we can create our custom Bean
    // And we can select the implementation we want for our dependency, without using the @Qualifier annotation
    @Bean
    public MyBean myBeanOperation(){
        return new MyBeanImplement2();
    }

    // Here we configure the another bean
    @Bean
    public MyBeanOperation myBeanSumOperation(){
        return new MyBeanOperationImplement();
    }

    // Here we add a bean that has a dependency, just pass the dependency as an argument
    // And return the bean with dependency using that argument
    @Bean
    public MyBeanWithDependency myBeanWithDependency(MyBeanOperation myBeanOperation){
        return new MyBeanWithDependencyImpl(myBeanOperation);
    }
}
