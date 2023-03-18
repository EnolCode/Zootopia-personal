package com.zootopia.demo.security;

// Este filtro es para el proceso de autorizacion, cuando el cliente quiera usar el token adjuntado ya a las solicitudes para ingresar a los endpoints

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component // Anotacion para que sea tratado como un objeto gestionado por el nucleo de Spring y usar las capacidades que nos ofrece
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
     
    String bearerToken = request.getHeader("Authorization"); //Este proceso ya no es para autenticarse si no para usarlos en las endpoints
    if(bearerToken != null && bearerToken.startsWith("Bearer ")){ // Verificamos que el token sea el correcto
        String token = bearerToken.replace("Bearer ", ""); // Extraemos el Token quitando la palabra bearer y su espacio.
        UsernamePasswordAuthenticationToken usernamePAT = TokenUtils.getAuthentication(token); // Creamos una instancia y lo extraemos enviandole el token
        SecurityContextHolder.getContext().setAuthentication(usernamePAT); // Establecemos la autenticacion
    }

    filterChain.doFilter(request, response); // Enviamos la data
}


    
}
