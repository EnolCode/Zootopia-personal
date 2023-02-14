package com.zootopia.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.zootopia.demo.entity.Type;

public interface TypeService {
    
    public List<Type> findAll();

    public Page<Type> findAll(Pageable pageable);

    public Optional<Type> findById(Long id);

    public Type save(Type type);

    public void deleteById(Long id);

}
