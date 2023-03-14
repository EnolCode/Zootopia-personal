package com.zootopia.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zootopia.demo.entity.User;
import com.zootopia.demo.repository.UserRepository;
import com.zootopia.demo.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

        @Autowired
        private UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
           User user =  userRepository
                .findOneByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("The user with the email " + email + " does not exist"));

            return new UserDetailsImpl(user);
        }
        
    }