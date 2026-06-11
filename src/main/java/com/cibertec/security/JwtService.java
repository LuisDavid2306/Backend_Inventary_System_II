package com.cibertec.security;

import java.security.Key;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;

import com.cibertec.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;

@Service
public class JwtService {
	
	private static final String SECRET_KEY =
            "Inventary_System_2026_Mi_Clave_Secreta_JWT_Cibertec";
	
	public JwtService() {
	    System.out.println("JWT SERVICE OK");
	}
	
	private final Key key =
	        Keys.hmacShaKeyFor(
	            SECRET_KEY.getBytes(StandardCharsets.UTF_8)
	        );

	public String generateToken(User user) {

	    return Jwts.builder()
	            .subject(user.getUsername())
	            .claim("role", user.getRole())
	            .issuedAt(new Date())
	            .expiration(
	                    new Date(System.currentTimeMillis()
	                            + 1000 * 60 * 60))
	            .signWith(key)
	            .compact();
	}
	
	public String extractUsername(String token) {

	    return Jwts.parser()
	            .verifyWith((SecretKey) key)
	            .build()
	            .parseSignedClaims(token)
	            .getPayload()
	            .getSubject();
	}
	
	public boolean isTokenValid(String token, String username) {

	    String tokenUsername = extractUsername(token);

	    return tokenUsername.equals(username);
	}
	
}
