package com.zootopia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zootopia.demo.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{  
      
}
