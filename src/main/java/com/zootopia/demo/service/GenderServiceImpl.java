package com.zootopia.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zootopia.demo.entity.Gender;
import com.zootopia.demo.repository.GenderRepository;


@Service
public class GenderServiceImpl implements GenderService {

    @Autowired 
    private GenderRepository genderRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Gender> findAll() {

        return genderRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Gender> findAll(Pageable pageable) {
        return genderRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Gender> findById(Long id) {
        return genderRepository.findById(id);
    }

    @Transactional
    @Override
    public Gender save(Gender gender) {
        return genderRepository.save(gender);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        genderRepository.deleteById(id);
    }
    
}
