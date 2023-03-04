package com.zootopia.demo.service;

import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zootopia.demo.Exception.UserAlreadyExistsException;
import com.zootopia.demo.Exception.UserServiceException;
import com.zootopia.demo.entity.User;
import com.zootopia.demo.repository.UserRepository;

@Service
public class UserService {
   private final  UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User store(User user) { 

        Optional<User> userOptional = repository.findByUsername(user.getUsername());

        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException("El usuario ya existe.");
        }
        try {          
                String encodedPassword = passwordEncoder.encode(user.getPassword());
                user.setPassword(encodedPassword);
                return repository.save(user);
            
        } catch (DataAccessException e) {
            throw new UserServiceException("Dont save user", e);
        }
    }
}
