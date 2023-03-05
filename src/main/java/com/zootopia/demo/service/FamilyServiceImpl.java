package com.zootopia.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zootopia.demo.entity.Family;
import com.zootopia.demo.repository.FamilyRepository;

@Service
public class FamilyServiceImpl implements BaseService<Family> {

    private FamilyRepository repository;

    public FamilyServiceImpl(FamilyRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Family> findAll() {

        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Family> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Family> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Family save(Family family) {
        return repository.save(family);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
