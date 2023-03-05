package com.zootopia.demo.config;


// import java.util.ArrayList;
// import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.zootopia.demo.service.SecurityUserDetailsService;


@ComponentScan 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    MyBasicAuthenticationEntryPoint authenticationEntryPoint;

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
                        .logoutUrl("/api/logout")
                        .deleteCookies("JSESSIONID"))   
      .authorizeRequests((auth) -> auth
                        .antMatchers("/api/register").permitAll()
                        .antMatchers( "/api/animals", "/api/country").hasRole("ADMIN")
                        .antMatchers( "/api/login").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated())
                .userDetailsService(service)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .httpBasic(basic -> basic.authenticationEntryPoint(authenticationEntryPoint))
                .httpBasic(Customizer.withDefaults());
                // http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
                // httpBasic(Customizer.withDefaults());
                return http.build();
    }

    // @Bean 
    // public InMemoryUserDetailsManager userDetailsService(){

    //     PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    //     String password = encoder.encode("1234");
    //     System.out.println(password);

    //     UserDetails user = User.withUsername("admin")
    //             .password(password)
    //             .roles("ADMIN")
    //             .build();

    //     UserDetails user2 = User.withUsername("user")
    //             .password(password)
    //             .roles("USER")
    //             .build();

    //     Collection<UserDetails> users = new ArrayList<>();

    //         users.add(user);
    //         users.add(user2);

    //     return new InMemoryUserDetailsManager(users);
    // }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
