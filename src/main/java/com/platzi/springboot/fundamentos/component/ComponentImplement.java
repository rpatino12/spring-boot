package com.platzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

// This is the implementation of the dependency, we have to use the @Component annotation
@Component
public class ComponentImplement implements ComponentDependency{
    @Override
    public void sayHello() {
        System.out.println("Hello world from my Component");
    }
}
