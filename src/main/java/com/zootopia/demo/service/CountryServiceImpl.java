package com.zootopia.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zootopia.demo.entity.Country;
import com.zootopia.demo.repository.CountryRepository;

@Service
public class CountryServiceImpl implements BaseService<Country> {

    private CountryRepository repository;

    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }
    @Override
    @Transactional(readOnly = true)
    public List<Country> findAll() {

        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Country> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Country> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Country update(Country existingCountry, Country updatedCountry) {
        existingCountry.setCountry(updatedCountry.getCountry());
        return repository.save(existingCountry);
    }

    @Transactional
    @Override
    public Country save(Country country) {
        return repository.save(country);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
