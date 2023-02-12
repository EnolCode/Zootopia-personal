package com.zootopia.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zootopia.demo.entity.Type;
import com.zootopia.demo.repository.TypeRepository;


@Service
public class TypeServiceImpl implements TypeService {

    @Autowired 
    private TypeRepository typeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Type> findAll() {

        return typeRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Type> findAll(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Type> findById(Long id) {
        return typeRepository.findById(id);
    }

    @Transactional
    @Override
    public Type save(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        typeRepository.deleteById(id);
    }
    
}
