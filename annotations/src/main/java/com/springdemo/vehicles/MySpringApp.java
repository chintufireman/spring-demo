package com.springdemo.vehicles;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext
			= new ClassPathXmlApplicationContext("config.xml");
		
		Car bean = applicationContext.getBean("car",Car.class);
		System.out.println(bean.getMilage());
		
		System.out.println(bean.getDiscountMessage());
		System.out.println(bean.getMrp());
	}
}
