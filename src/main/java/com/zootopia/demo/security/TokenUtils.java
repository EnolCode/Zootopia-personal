package com.zootopia.demo.security;

import java.util.*;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.userdetails.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "4qhq8LrEBfYcdRHxhdb9zURb2rf8e7Ud"; // En producción será mas segura

    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L; // 30 dias en segundos, en pdorucción será menor

    public static String createToken(String nombre, String email) { // Hacemos este metodo para enviar datos en el mismo token
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;  // Convertimos en milisegundos para manejarlo mejor
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime); // Suma los milisegundos que le quedan a la fecha actual en milisegundos

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre); // Agregamos el nombre del usuario que viajara con el token

        return Jwts.builder() //Contruimos el token
                .setSubject(email)  // A quien esta dirigido el token, en este caso usamos el email
                .setExpiration(expirationDate)  // Establecemos la expiracion
                .addClaims(extra)   // Data adiccional que queramos en el extra
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes())) // Lo firmamos usando esta clase
                .compact(); // compactamos y produce un token
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {

        try {
            Claims claims = Jwts.parserBuilder()
            .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
            .build()
            .parseClaimsJws(token) // Le enviamos el token que estamos recibiendo como parametro
            .getBody();
    
            String email = claims.getSubject(); // Obtenemos el email del token

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList()); // 1 parametro = autenticarse con email, 3 parametro = lista vacia 
            
        } catch (JwtException e) {
            return null;    
        }
    }
}
