package com.zootopia.demo.service;

import static org.mockito.Mockito.when;

import java.util.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.zootopia.demo.entity.Role;
import com.zootopia.demo.entity.User;
import com.zootopia.demo.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class SecurityUserDetailsServiceTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    SecurityUserDetailsService service;

    @Test
    void testLoadUserByUsername_returnUserDetails() {
        // given
        String username = "admin";

        // when
        Set<Role> roles = new HashSet<>();
        Role role = new Role("ADMIN");
        roles.add(role);

        User user = new User("admin", "1234", roles);

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());

        when(repository.findByUsername(username)).thenReturn(Optional.of(user));
        UserDetails userDetails = service.loadUserByUsername(username);

        assertThat(userDetails).isNotNull();
        assertThat(userDetails.getUsername()).isEqualTo(username);
        assertThat(userDetails.getPassword()).isEqualTo("1234");
        assertThat(userDetails.getAuthorities().size()).isEqualTo(1);
        assertThat(userDetails.getAuthorities().toArray()).contains(authority);
    }
}
