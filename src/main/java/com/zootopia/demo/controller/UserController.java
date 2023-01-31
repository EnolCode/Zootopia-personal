package com.zootopia.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.demo.entity.User;
import com.zootopia.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    //Creamos nuevo usuario
    @PostMapping // Abreviatura  de RqquestMapping para decir que es un metodo post
    public ResponseEntity<?> create (@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    // Leer un usuario
    @GetMapping("/{id}") // Abreviatura  de RqquestMapping para decir que es un metodo get
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<User> oUser = userService.findById(id);

        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build(); // Si el usuario no es encontrado por el id deveulve un not found
        }

        return ResponseEntity.ok(oUser);  // Si esta todo bien devuelve un 200 y el usuario,  si llega hasta aqui siempre habra un user para mostrar
    }


}
