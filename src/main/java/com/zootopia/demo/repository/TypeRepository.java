package com.zootopia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zootopia.demo.entity.Type;

public interface TypeRepository extends JpaRepository<Type, Long>{
}
