package com.zootopia.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // Actualizar usuario

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User userDetails, @PathVariable Long id){
        Optional<User> user = userService.findById(id);

        if(!user.isPresent()){
            return ResponseEntity.notFound().build(); 
        }

        // BeanUtils.copyProperties(userDetails, user.get()) Con esta linea podemos modificar todo el objeto, pero en este caso no queremos modificar el id
        user.get().setName(userDetails.getName()); // Coge el nombre que le pasamos y lo inyecta en el usuario que queremos modificar
        user.get().setSurname(userDetails.getSurname());
        user.get().setEmail(userDetails.getEmail());
        user.get().setEnabled(userDetails.getEnabled());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get())); 

    }

    // Eliminar usuario

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        if(!userService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteById(id);

        return ResponseEntity.ok().build();
    }

    // Leer todos los usuarios
    @GetMapping
    public List<User> readAll() {
        List<User> users =  StreamSupport
                    .stream(userService.findAll().spliterator(),false) // Nos recorre todos los usuarios secuancialemnte en vez de paralelo(por eso pusimos el false) JAVA 8 Stream
                    .collect(Collectors.toList());  // Para pasarlo a una lista

    return users;

    }
}
