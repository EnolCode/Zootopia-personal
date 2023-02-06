package com.zootopia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zootopia.demo.entity.Animal;


public interface AnimalRepository extends JpaRepository<Animal, Long>{
    
}
