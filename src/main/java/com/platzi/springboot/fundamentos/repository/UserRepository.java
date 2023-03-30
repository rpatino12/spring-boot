package com.platzi.springboot.fundamentos.repository;

import com.platzi.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// Here we create the User table
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // We can use queries like in SQL, using JPQL, this is the query language defined by JPA
    // It's similar to SQL but operates over Java objects (you can SELECT, UPDATE and DELETE)
    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name LIKE ?1%")
    List<User> findAndSort(String name, Sort sort);

    // Query methods, this is an alternative to the @Query annotation of JPQL
    List<User> findByName(String name);
    Optional<User> findByEmailAndName(String email, String name);
}
