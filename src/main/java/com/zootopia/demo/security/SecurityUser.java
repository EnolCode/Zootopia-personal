package com.zootopia.demo.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.zootopia.demo.entity.User;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class SecurityUser implements UserDetails{

    private final User user;

    @Override
    public String getUsername(){
        return user.getUsername();
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return user.getAuthorities().stream().map(SecurityAuthority::new).toList();
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    
    @Override
    public boolean isEnabled(){
        return true;
    }
    
    
    
}
