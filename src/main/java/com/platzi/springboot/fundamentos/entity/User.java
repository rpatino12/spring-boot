package com.platzi.springboot.fundamentos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    // Here we set the autoincrement for the user id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false, unique = true)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String email;

    private LocalDate birthdate;

    // And here we also have to set the relation with the post table
    // We have to use the annotation JsonManagedReference, so we don't get an error related with stackoverflow
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(String name, String email, LocalDate birthdate) {
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", posts=" + posts +
                '}';
    }
}
