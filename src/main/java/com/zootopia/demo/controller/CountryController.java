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

import com.zootopia.demo.entity.Country;
import com.zootopia.demo.service.CountryService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @PostMapping(value= "/country" , consumes="application/*" )
    public ResponseEntity<?> create (@RequestBody Country country) {
        return ResponseEntity.status(HttpStatus.CREATED).body(countryService.save(country));
    }

    @GetMapping("/country/{id}") 
    public ResponseEntity<?> read(@PathVariable Long id){
        Optional<Country> oCountry = countryService.findById(id);
        if(!oCountry.isPresent()){
            return ResponseEntity.notFound().build(); 
        }
        return ResponseEntity.ok(oCountry);  
    }
    
    @PutMapping("/country/{id}")
    public ResponseEntity<?> update(@RequestBody Country countryDetails, @PathVariable Long id){
        Optional<Country> country = countryService.findById(id);
        if(!country.isPresent()){
            return ResponseEntity.notFound().build();
        }
        country.get().setCountry(countryDetails.getCountry()); 
        
        return ResponseEntity.status(HttpStatus.CREATED).body(countryService.save(country.get()));
    }
    
    @DeleteMapping("/country/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        if(!countryService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        countryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    
    @GetMapping("/countries") 
    public List<Country> readAll() {
        return countryService.findAll();

    }
}
