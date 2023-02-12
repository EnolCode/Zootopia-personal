package com.zootopia.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.zootopia.demo.entity.Country;

public interface CountryService {
    
    public List<Country> findAll();

    public Page<Country> findAll(Pageable pageable);

    public Optional<Country> findById(Long id);

    public Country save(Country country);

    public void deleteById(Long id);

}