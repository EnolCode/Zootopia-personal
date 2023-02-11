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
            return ResponseEntity.notFound().build(); // Si el usuario no es encontrado por el id deveulve un not found
        }
        return ResponseEntity.ok(oAnimal);  // Si esta todo bien devuelve un 200 y el usuario,  si llega hasta aqui siempre habra un user para mostrar
    }
    // Actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Animal animalDetails, @PathVariable Long id){
        Optional<Animal> animal = animalService.findById(id);
        if(!animal.isPresent()){
            return ResponseEntity.notFound().build();
        }
        // BeanUtils.copyProperties(userDetails, user.get()) Con esta linea podemos modificar todo el objeto, pero en este caso no queremos modificar el id
        animal.get().setName(animalDetails.getName()); // Coge el nombre que le pasamos y lo inyecta en el usuario que queremos modificar
        animal.get().setDate(animalDetails.getDate());
        // animal.get().setEmail(animalDetails.getEmail());
        // animal.get().setEnabled(animalDetails.getEnabled());
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.save(animal.get()));
    }
    // Eliminar usuario
    /**
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        if(!animalService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        animalService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    // Leer todos los usuarios
    @GetMapping
    public List<Animal> readAll() {
        return animalService.findAll();

        /* List<Animal> animals =  StreamSupport
                    .stream(animalService.findAll().spliterator(),false) // Nos recorre todos los usuarios secuancialemnte en vez de paralelo(por eso pusimos el false) JAVA 8 Stream
                    .collect(Collectors.toList());  // Para pasarlo a una lista
    return animals; */
    }
}