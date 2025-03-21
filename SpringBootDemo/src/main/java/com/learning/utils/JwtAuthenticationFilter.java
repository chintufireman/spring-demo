package com.learning.utils;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.learning.services.EmployeService;
import com.learning.services.EmployeServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	public EmployeServiceImpl employeService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		String authHeader = request.getHeader("Authorization");
		if(authHeader!=null && authHeader.startsWith("Bearer ")) {
			String token = authHeader.substring(7);
			if(jwtUtils.validateToken(token)) {
				String userNameFromToken = jwtUtils.getUserNameFromToken(token);
				
				UserDetails loadUserByUsername = employeService.loadUserByUsername(userNameFromToken);
				
				if(SecurityContextHolder.getContext().getAuthentication() == null) {
					
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
							new UsernamePasswordAuthenticationToken
							(loadUserByUsername
									, null
									, loadUserByUsername.getAuthorities());
					
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}
		}
		
		//to forward request
		filterChain.doFilter(request, response);
	}
}
