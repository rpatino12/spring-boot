package com.platzi.springboot.fundamentos.repository;

import com.platzi.springboot.fundamentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Here we create the User table
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
