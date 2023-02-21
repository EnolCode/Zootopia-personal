package com.zootopia.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zootopia.demo.entity.Family;
import com.zootopia.demo.service.FamilyService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @PostMapping(value= "/family" , consumes="application/*" )
    public ResponseEntity<?> create (@RequestBody Family family) {
        return ResponseEntity.status(HttpStatus.CREATED).body(familyService.save(family));
    }

    @GetMapping("/family/{id}") 
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Family> oFamily = familyService.findById(id);
        if(!oFamily.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oFamily);  
    }

    @PutMapping("/family/{id}")
    public ResponseEntity<?> update(@RequestBody Family familyDetails, @PathVariable Long id){
        Optional<Family> family = familyService.findById(id);
        if(!family.isPresent()){
            return ResponseEntity.notFound().build();
        }
        family.get().setFamily(familyDetails.getFamily()); 
        
        return ResponseEntity.status(HttpStatus.CREATED).body(familyService.save(family.get()));
    }
    

    @DeleteMapping("/family/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        if(!familyService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        familyService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    
    @GetMapping("/families") 
    public List<Family> readAll() {
        return familyService.findAll();

    }
}
