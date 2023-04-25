package com.example.Bookstore.security.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public interface JwtService {
	
	String extractUsername(String token);
	
	<T> T extractClaims(String token, Function<Claims, T> claimsResolver);
	
	String generateToken(UserDetails userDetails);
	
	String generateToken(Map<String,Object> extraClaims, UserDetails userDetails);
	
	boolean isTokenValid(String token, UserDetails userDetails);
		
}
