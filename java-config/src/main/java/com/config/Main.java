package com.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);
		 // to get the config details from java file
		Vehicle bean = context.getBean("car", Vehicle.class);
		System.out.println(bean.getMileage());
		bean.getDiscountMsg();
		System.out.println(bean.getCarValue());
	}
}
