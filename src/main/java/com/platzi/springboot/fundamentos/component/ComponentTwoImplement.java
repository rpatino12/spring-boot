package com.platzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void sayHello() {
        System.out.println("Hello world from my second Component");
    }
}
