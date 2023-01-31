package com.zootopia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zootopia.demo.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
    
}
