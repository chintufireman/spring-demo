package com.learning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.learning.utils.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	JwtAuthenticationFilter authenticationFilter;
	
	@Autowired
	CustomAuthenticationEntryPoint authenticationEntryPoint;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		
		http.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(
					auth->auth
							.requestMatchers(HttpMethod.GET,"/emp/**")
							.permitAll()
							.requestMatchers(HttpMethod.POST,"/emp/**")
							.permitAll()
							.requestMatchers("/emp/**")
							.authenticated()
							.anyRequest().permitAll()
			)
			.exceptionHandling(e->e.authenticationEntryPoint(authenticationEntryPoint))
			.sessionManagement(
					session ->
					session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			)
			.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
			
		
		return http.build();
	}
	
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}
