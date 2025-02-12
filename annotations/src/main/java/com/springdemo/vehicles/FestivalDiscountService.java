package com.springdemo.vehicles;

import org.springframework.stereotype.Component;

@Component
public class FestivalDiscountService implements DiscountService {

	public String getDiscount() {
		return "100% off";
	}

}
