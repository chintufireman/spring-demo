package com.springdemo.vehicles;

import org.springframework.stereotype.Component;

@Component
public class NoDiscountServiceImpl implements DiscountService {

	public String getDiscount() {
		return "No discount service";
	}

}
