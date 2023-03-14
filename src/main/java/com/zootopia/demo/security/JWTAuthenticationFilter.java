package com.zootopia.demo.security;

import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                 HttpServletResponse response) throws AuthenticationException {

        AuthCredentials authCredentials = new AuthCredentials();

        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class); // Convertimos el json que nos llega en credenciales
        } catch (Exception e) {

        }

        UsernamePasswordAuthenticationToken usernamePat = new UsernamePasswordAuthenticationToken(
             authCredentials.getEmail(), // Creamos u usuario y le enviamos estos parametros
             authCredentials.getPassword(),
             Collections.emptyList()
        );

        return getAuthenticationManager().authenticate(usernamePat); 
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, 
                                            FilterChain chain,
                                            Authentication authResult) throws java.io.IOException, ServletException {

        UserDetailsImpl userDetails = (UserDetailsImpl)authResult.getPrincipal(); 
        String token = TokenUtils.createToken(userDetails.getName(), userDetails.getUsername()); // El token creado con la autenticacion y los parametros creados

        response.addHeader("Authorization", "Bearer " + token);
        response.getWriter().flush(); // para confirmar todos estos cambios
        super.successfulAuthentication(request, response, chain, authResult);
    }

}
