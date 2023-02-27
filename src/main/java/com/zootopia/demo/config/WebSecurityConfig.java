package com.zootopia.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http
       .httpBasic()
                .and().authorizeHttpRequests()
                // .requestMatchers(new AntPathRequestMatcher("/api/animals")).permitAll()
                // .requestMatchers(new AntPathRequestMatcher("/api/animals/new")).hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/animals").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/animals").permitAll()
                .and().csrf().disable().build();
    }

    @Bean 
    UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(
            User.withUsername("user")
                .password(passwordEncoder().encode("password123"))
                .authorities("read", "write","ROLE_USER")
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
