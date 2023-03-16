package com.platzi.springboot.fundamentos.bean;

public class MyBeanPropertiesImpl implements MyBeanProperties {
    private String name;
    private String lastName;
    private String random;

    public MyBeanPropertiesImpl(String name, String lastName, String random) {
        this.name = name;
        this.lastName = lastName;
        this.random = random;
    }

    @Override
    public String showProperties() {
        return "name: " + name + "\nlast name: " + lastName + "\nrandom: " + random;
    }
}
