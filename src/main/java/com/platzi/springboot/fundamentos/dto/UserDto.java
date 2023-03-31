package com.platzi.springboot.fundamentos.dto;

import java.time.LocalDate;

// This class of data transfer object (DTO), is used to represent the data that we want to get from a query
// DTO classes are very effective for data transfer between client and server
// It's used to create every view we may need of tables or data
public class UserDto {
    private Long id;
    private String name;
    private LocalDate birthdate;

    public UserDto(Long id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
