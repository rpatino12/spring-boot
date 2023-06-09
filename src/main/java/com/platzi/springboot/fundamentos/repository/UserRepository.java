package com.platzi.springboot.fundamentos.repository;

import com.platzi.springboot.fundamentos.dto.UserDto;
import com.platzi.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
    List<User> findByNameLike(String name);
    List<User> findByNameOrEmail(String name, String email);
    List<User> findByBirthdateBetween(LocalDate startDate, LocalDate endDate);
    List<User> findByNameLikeOrderByIdDesc(String name);
    List<User> findByNameContainingOrderByIdDesc(String name);
    List<User> findByNameContainingAndBirthdateBetween(String name, LocalDate startDate, LocalDate endDate);

    // Use of JPQL with named parameters (using @Param)
    @Query("SELECT new com.platzi.springboot.fundamentos.dto.UserDto(u.id, u.name, u.birthdate)" +
            " FROM User u WHERE u.birthdate=:dateParameter AND u.email=:emailParameter")
    Optional<UserDto> getAllByBirthdateAndEmail(@Param("dateParameter") LocalDate date,
                                                @Param("emailParameter") String email);
}
