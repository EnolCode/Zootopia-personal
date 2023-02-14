package com.zootopia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zootopia.demo.entity.Gender;

public interface GenderRepository extends JpaRepository<Gender, Long>{
    
}
