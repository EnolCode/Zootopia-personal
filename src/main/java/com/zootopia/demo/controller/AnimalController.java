package com.zootopia.demo.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zootopia.demo.entity.Animal;

import com.zootopia.demo.service.AnimalServiceImpl;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/animals")
public class AnimalController {
    @Autowired
    private AnimalServiceImpl animalService;

    @PostMapping(value = "", consumes="application/*" )
    public ResponseEntity<Animal> create (@RequestBody Animal animal) {
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
    public ResponseEntity<Animal> update(@RequestBody Animal animalDetails, @PathVariable Long id){
        Optional<Animal> oAnimal = animalService.findById(id);
        if(!oAnimal.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Animal updatedAnimal = animalService.update(oAnimal.get(), animalDetails);
        return ResponseEntity.status(HttpStatus.OK).body(updatedAnimal);
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