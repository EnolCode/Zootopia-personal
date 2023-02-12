package com.zootopia.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zootopia.demo.entity.Gender;
import com.zootopia.demo.service.GenderService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/")
public class GenderController {
    @Autowired
    private GenderService genderService;

    @PostMapping(value= "/gender" , consumes="application/*" )
    public ResponseEntity<?> create (@RequestBody Gender gender) {
        return ResponseEntity.status(HttpStatus.CREATED).body(genderService.save(gender));
    }

    @GetMapping("/gender/{id}") 
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Gender> oGender = genderService.findById(id);
        if(!oGender.isPresent()){
            return ResponseEntity.notFound().build(); // Si el usuario no es encontrado por el id deveulve un not found
        }
        return ResponseEntity.ok(oGender);  // Si esta todo bien devuelve un 200 y el usuario,  si llega hasta aqui siempre habra un user para mostrar
    }

    @PutMapping("/gender/{id}")
    public ResponseEntity<?> update(@RequestBody Gender genderDetails, @PathVariable Long id){
        Optional<Gender> gender = genderService.findById(id);
        if(!gender.isPresent()){
            return ResponseEntity.notFound().build();
        }
        gender.get().setGender(genderDetails.getGender()); 
        
        return ResponseEntity.status(HttpStatus.CREATED).body(genderService.save(gender.get()));
    }
    
    @DeleteMapping("/gender/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        if(!genderService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        genderService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/genders") 
    public List<Gender> readAll() {
        return genderService.findAll();

    }
}
