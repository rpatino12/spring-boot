package com.platzi.springboot.fundamentos.bean;

public class MyBeanOperationImplement implements MyBeanOperation{

    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
