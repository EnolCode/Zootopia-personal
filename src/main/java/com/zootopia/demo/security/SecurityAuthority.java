package com.zootopia.demo.security;

import org.springframework.security.core.GrantedAuthority;

import com.zootopia.demo.entity.Role;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority{
    
    private final Role authority;

    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
}
