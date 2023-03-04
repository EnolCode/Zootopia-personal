package com.zootopia.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.zootopia.demo.service.SecurityUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private SecurityUserDetailsService service;

    public WebSecurityConfig(SecurityUserDetailsService service) {
        this.service = service;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     http
      .cors()
      .and()
      .headers(header -> header.frameOptions().sameOrigin())
      .csrf(csrf -> csrf.disable())
      .formLogin(form-> form.disable())
      .logout(logout -> logout
                        .logoutUrl("api/logout")
                        .deleteCookies("JSESSIONID"))   
                .authorizeRequests((auth) -> auth
                        .antMatchers("/api/login").permitAll()
                        .antMatchers(HttpMethod.POST, "/api/animals").hasRole("ADMIN")
                        .antMatchers(HttpMethod.POST, "/api/country").hasRole("ADMIN")
                        .antMatchers(HttpMethod.GET, "/api/animals").hasAnyRole("ADMIN", "USER")
                        .antMatchers(HttpMethod.GET, "/api/country").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated())
                .userDetailsService(service)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .httpBasic(basic -> basic.authenticationEntryPoint(AuthenticationEntryPoint));
                http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
                return http.build();
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
