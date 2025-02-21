package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Car implements Vehicle {

	@Value("${car.mrp}") //this value will be inject from car.properties
	private double carValue;
	
	//either u can annotate its impl class with @component or create bean in 
	//config.java as u created for car
	//u can use Autowire here to inject its bean using field injection
	public DiscountService discountService;
	
	//step 1-create constructor to inject bean through constructor injection
	// step 2:- the created bean inside the config.java must pass the 
	// bean of DiscountService as a constructor's parameter
	//and hence constructor injection happens
	
	
	
	public String getMileage() {
		return "20kmpl";
	}
	
	public Car(DiscountService discountService) {
		this.discountService = discountService;
	}

	public void getDiscountMsg() {
		discountService.getDiscountMsg();
	}

	public double getCarValue() {
		return carValue;
	}

}
