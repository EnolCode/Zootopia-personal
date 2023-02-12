package com.zootopia.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zootopia.demo.entity.Family;
import com.zootopia.demo.repository.FamilyRepository;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired 
    private FamilyRepository familyRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Family> findAll() {

        return familyRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Family> findAll(Pageable pageable) {
        return familyRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Family> findById(Long id) {
        return familyRepository.findById(id);
    }

    @Transactional
    @Override
    public Family save(Family family) {
        return familyRepository.save(family);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        familyRepository.deleteById(id);
    }
    
}
