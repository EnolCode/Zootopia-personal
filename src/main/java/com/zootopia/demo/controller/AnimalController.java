package com.zootopia.demo.controller;
import java.util.List;
import java.util.Optional;
// import java.util.stream.Collectors;
// import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zootopia.demo.entity.Animal;

// import com.zootopia.demo.service.AnimalService;
import com.zootopia.demo.service.AnimalServiceImpl;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/animals")
public class AnimalController {
    @Autowired
    private AnimalServiceImpl animalService;
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