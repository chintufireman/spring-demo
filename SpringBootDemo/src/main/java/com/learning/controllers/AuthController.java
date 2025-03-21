package com.learning.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.AuthRequest;
import com.learning.dto.JwtResponse;
import com.learning.dto.RefreshTokenRequest;
import com.learning.entities.Employe;
import com.learning.services.EmployeServiceImpl;
import com.learning.utils.JwtUtils;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private EmployeServiceImpl serviceImpl;
	
	private Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody AuthRequest authRequest){
		logger.info("Inside login ");
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		String token = jwtUtils.generateToken(authRequest.getUsername(), true);
		String refreshToken = jwtUtils.generateToken(authRequest.getUsername(), false);
		
		Employe loadEmployeByName = serviceImpl.loadEmployeByName(authRequest.getUsername());
		return ResponseEntity.ok(new JwtResponse(token,refreshToken,loadEmployeByName));
	
	}
	@PostMapping("/refresh-token")
	public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest authRequest){
		if(jwtUtils.validateToken(authRequest.getRefreshToken())) {
			String userNameFromToken = jwtUtils.getUserNameFromToken(authRequest.getRefreshToken());
			//we can add more validation here
			String generateToken = jwtUtils.generateToken(userNameFromToken, true);
			String refreshToken = jwtUtils.generateToken(userNameFromToken, true);
			
			
			Employe loadEmployeByName = serviceImpl.loadEmployeByName(userNameFromToken);
			return ResponseEntity.ok(new JwtResponse(generateToken,refreshToken,loadEmployeByName));
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Refresh token");
	}
	
	
}
