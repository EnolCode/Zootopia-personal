package com.zootopia.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zootopia.demo.entity.Gender;

public interface GenderService {
    
    public List<Gender> findAll();

    public Page<Gender> findAll(Pageable pageable);

    public Optional<Gender> findById(Long id);

    public Gender save(Gender gender);

    public void deleteById(Long id);

}
