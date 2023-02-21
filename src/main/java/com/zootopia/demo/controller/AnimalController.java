package com.zootopia.demo.controller;
import java.util.List;
import java.util.Optional;
// import java.util.stream.Collectors;
// import java.util.stream.StreamSupport;
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

import com.zootopia.demo.entity.Animal;

import com.zootopia.demo.service.AnimalService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/animals")
public class AnimalController {
    @Autowired
    private AnimalService animalService;
    //Creamos nuevo usuario

    @PostMapping(value = "", consumes="application/*" )
    public ResponseEntity<?> create (@RequestBody Animal animal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.save(animal));
    }

    @GetMapping("/{id}") 
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Animal> oAnimal = animalService.findById(id);
        if(!oAnimal.isPresent()){
            return ResponseEntity.notFound().build(); 
        }
        return ResponseEntity.ok(oAnimal);  
    
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Animal animalDetails, @PathVariable Long id){
        Optional<Animal> animal = animalService.findById(id);
        if(!animal.isPresent()){
            return ResponseEntity.notFound().build();
        }
        animal.get().setName(animalDetails.getName());
        animal.get().setDate(animalDetails.getDate());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.save(animal.get()));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        if(!animalService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        animalService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping
    public List<Animal> readAll() {
        return animalService.findAll();        
    }
}