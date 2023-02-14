package com.zootopia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zootopia.demo.entity.Family;

public interface FamilyRepository extends JpaRepository<Family, Long> {
    
}
