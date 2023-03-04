package com.zootopia.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.demo.entity.User;
import com.zootopia.demo.service.UserService;

@RestController
@RequestMapping("/api")
public class RegisterController {
    
    UserService service;

    public RegisterController(UserService service){
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            service.store(user);
            return ResponseEntity.status(201).body("Register successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Register failed");
        }
    }
}
