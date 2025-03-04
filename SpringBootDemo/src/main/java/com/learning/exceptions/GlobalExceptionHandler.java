package com.learning.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
}
