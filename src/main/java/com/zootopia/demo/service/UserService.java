package com.zootopia.demo.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zootopia.demo.entity.User;
import com.zootopia.demo.repository.UserRepository;

@Service
public class UserService {
    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User Store(User user) { 
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedePassword);

        return repository.save(user);
    }
}
