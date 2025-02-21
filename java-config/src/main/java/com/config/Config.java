package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // to make this class available as config file to spring and create beans
@ComponentScan("com.config") // to search for components in spring project
@PropertySource("car.properties")//to important car.properties here
public class Config {

	@Bean
	public Vehicle car() { // name of bean = method's name
		Vehicle car = new Car(discountService());
		return car;
	}
	@Bean
	public DiscountService discountService() { // name of bean = method's name
		DiscountService discountService = new FestivalDiscountService();
		return discountService;
	}
}
