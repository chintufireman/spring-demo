package com.learning.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.jsonwebtoken.JwtException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,String>> 
		handleSourceNotFoundException(ResourceNotFoundException ex){
			HashMap<String, String> response = new HashMap<>();
			response.put("Error:",ex.getMessage());
			return new 
					ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<Map<String,String>> 
	handleAuthenticationException(AuthenticationException ex){
		HashMap<String, String> response = new HashMap<>();
		response.put("Error:","Authentication failed");
		return new 
				ResponseEntity<Map<String,String>>(response,HttpStatus.UNAUTHORIZED);
	}
	@ExceptionHandler(JwtException.class)
	public ResponseEntity<Map<String,String>> 
	handleJwtException(JwtException ex){
		HashMap<String, String> response = new HashMap<>();
		response.put("error_stack", ex.getMessage());
		response.put("Error:","Invalid Jwt token");
		return new 
				ResponseEntity<Map<String,String>>(response,HttpStatus.UNAUTHORIZED);
	}
}
