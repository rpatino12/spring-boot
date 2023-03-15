package com.platzi.springboot.fundamentos.bean;

public class MyBeanImplement implements MyBean{
    @Override
    public void print() {
        System.out.println("Hi from my own implementation of My Bean!!!");
    }
}
