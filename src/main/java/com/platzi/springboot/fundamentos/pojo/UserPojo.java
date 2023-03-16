package com.platzi.springboot.fundamentos.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

// We are going to create a class to work with the properties set in the application.properties file
// We have to use this annotation
// This is used to construct the pojo from the properties set and the prefix is for address the properties correctly
@ConfigurationProperties(prefix = "user")
public class UserPojo {
    private String email;
    private String password;
    private int age;

    public UserPojo(String email, String password, int age) {
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "UserPojo{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
