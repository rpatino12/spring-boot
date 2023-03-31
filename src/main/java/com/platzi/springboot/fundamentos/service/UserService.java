package com.platzi.springboot.fundamentos.service;

import com.platzi.springboot.fundamentos.entity.User;
import com.platzi.springboot.fundamentos.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

// This class is a dependency to represent the services and implement business logic
// We have to use the @Service annotation so Spring Boot knows this is a service class, to create registers
@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // This annotation allow us to validate the new registers and only insert the values if everything is correct
    @Transactional
    public void saveTransactional(List<User> users){
        users.stream()
                .peek(user -> LOG.info("Insert transaction: " + user))
                .forEach(userRepository::save);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
