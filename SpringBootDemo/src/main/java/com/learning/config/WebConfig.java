package com.learning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.learning.interceptors.LoggingInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Autowired
	LoggingInterceptor interceptor;
	// by the way spring beans can talk with any bean
	
	//to register ur interceptors
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor)
			.addPathPatterns("/emp/**")
			.excludePathPatterns("/auth/**");
	}

	
}
