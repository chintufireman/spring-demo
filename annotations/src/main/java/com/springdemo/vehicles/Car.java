package com.springdemo.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("car") 
public class Car implements Vehicle {
	
	@Value("${car.mrp}")
	String mrp;
	//field injection
	@Autowired
	@Qualifier("noDiscountServiceImpl")
	private DiscountService discountService;
	
	//constructor injection
//	@Autowired
//	public Car(@Qualifier("noDiscountServiceImpl") DiscountService discountService) {
//		this.discountService = discountService;
//	}

	//setter injection
//	@Autowired
//	@Qualifier("noDiscountServiceImpl")
//	public void setDiscountService(DiscountService discountService) {
//		this.discountService = discountService;
//	}

	
	public String getMilage() {
		return "82 kmph";
	}


	public String getMrp() {
		return mrp;
	}


	public String getDiscountMessage() {
		return discountService.getDiscount();
	}

}
