package com.zootopia.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zootopia.demo.entity.Animal;
import com.zootopia.demo.repository.AnimalRepository;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired 
    private AnimalRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Animal> findAll() {

        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Animal> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Animal> findById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    @Override
    public Animal save(Animal animal) {
        return userRepository.save(animal);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
         userRepository.deleteById(id);
    }
    
}
