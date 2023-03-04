package com.zootopia.demo.service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.zootopia.demo.repository.UserRepository;
import com.zootopia.demo.security.SecurityUser;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public SecurityUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository
            .findByUsername(username)
            .map(SecurityUser::new)
            .orElseThrow(()-> new UsernameNotFoundException("User not found: " + username));
    }
}
