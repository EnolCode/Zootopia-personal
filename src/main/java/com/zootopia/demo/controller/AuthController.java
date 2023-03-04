package com.zootopia.demo.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {
    
    @GetMapping("/login")
    public ResponseEntity <Map<String,String>> access(){
        
        var auth = SecurityContextHolder.getContext().getAuthentication();

        Map<String,String> json = new HashMap<>();
        json.put("message", "Logged");
        json.put("role", auth.getAuthorities().iterator().next().toString());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
    }
}
