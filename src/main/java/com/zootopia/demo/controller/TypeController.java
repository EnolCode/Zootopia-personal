package com.zootopia.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.zootopia.demo.entity.Type;
import com.zootopia.demo.service.TypeServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class TypeController {
    @Autowired
    private TypeServiceImpl typeService;

    @PostMapping(value= "/type" , consumes="application/*" )
    public ResponseEntity<?> create (@RequestBody Type type) {
        return ResponseEntity.status(HttpStatus.CREATED).body(typeService.save(type));
    }

    @GetMapping("/type/{id}") 
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Type> oType = typeService.findById(id);
        if(!oType.isPresent()){
            return ResponseEntity.notFound().build(); 
        }
        return ResponseEntity.ok(oType);  
    }

    @PutMapping("/type/{id}")
    public ResponseEntity<?> update(@RequestBody Type typeDetails, @PathVariable Long id){
        Optional<Type> type = typeService.findById(id);
        if(!type.isPresent()){
            return ResponseEntity.notFound().build();
        }
        type.get().setType(typeDetails.getType()); 
        
        return ResponseEntity.status(HttpStatus.CREATED).body(typeService.save(type.get()));
    }
    
    @DeleteMapping("/type/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        if(!typeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        typeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/types") 
    public List<Type> readAll() {
        return typeService.findAll();

    }
}
