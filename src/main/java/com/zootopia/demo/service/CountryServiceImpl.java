package com.zootopia.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zootopia.demo.entity.Country;
import com.zootopia.demo.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired 
    private CountryRepository countryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Country> findAll() {

        return countryRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Country> findAll(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Transactional
    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
    
}
