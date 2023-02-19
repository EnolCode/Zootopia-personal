package com.zootopia.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
                .httpBasic()
                .and().authorizeHttpRequests()
                .anyRequest().hasRole("ADMIN")
                .and().csrf().disable().build();
    }

    @Bean 
    public UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(
            User.withUsername("user")
                .password(passwordEncoder().encode("password123"))
                .authorities("read","ROLE_USER")
                .build(), 
                User.withUsername("admin")
                .password(passwordEncoder().encode("password123"))
                .authorities("read", "write", "ROLE_ADMIN")
                .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
