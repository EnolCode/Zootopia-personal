package com.zootopia.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zootopia.demo.entity.Animal;

public interface AnimalService {
    
    public Iterable<Animal> findAll();

    public Page<Animal> findAll(Pageable pageable);

    public Optional<Animal> findById(Long id);

    public Animal save(Animal animal);

    public void deleteById(Long id);

}
