package com.zootopia.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zootopia.demo.entity.Family;

public interface FamilyService {
    
    public List<Family> findAll();

    public Page<Family> findAll(Pageable pageable);

    public Optional<Family> findById(Long id);

    public Family save(Family family);

    public void deleteById(Long id);

}
