package com.zootopia.demo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zootopia.demo.repository.UserRepository;
import com.zootopia.demo.security.SecurityUser;

@Service
public class UserDetailsService {
    
    private final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var optUser = this.userRepository.findByUsername(username);
        
        if(optUser.isPresent()) {
            return new SecurityUser(optUser.get());
        }

        throw new UserNotFoundException("User not found: " + username);
    }

}
