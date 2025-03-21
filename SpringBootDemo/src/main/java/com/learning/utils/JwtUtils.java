package com.learning.utils;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

	final static private String secret_key="harshwardhan";
	final static private long access_token_expiration_time=15*60*1000;
	final static private long refresh_token_expiration=24*60*60*1000;
	
	
	
	public String generateToken(String username,boolean isAccessToken) {
		
		long expiration=
				isAccessToken ? access_token_expiration_time : refresh_token_expiration;
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+expiration))
				.signWith(Keys.hmacShaKeyFor(secret_key.getBytes()), SignatureAlgorithm.HS256)
				.compact();
	}
	
	public String getUserNameFromToken(String token) {
		return Jwts.parser()
				.setSigningKey(secret_key
						.getBytes())
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
					
	}
	
	public boolean validateToken(String token) {
		
		try {
			Jwts.parser()
			.setSigningKey(secret_key
					.getBytes())
			.build()
			.parseClaimsJws(token);
		}
		catch (JwtException e) {
			return false;
		}
		
		return true;
	}
}
