package com.demo.vehicles;

public class Car implements Vehicle{

	DiscountService discountService;
	
	double maxPrice;
	
	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Car(DiscountService discountService) {
		super();
		this.discountService = discountService;
	}

	public int getMilage() {
		return 22;
	}

	public String getDiscount() {
		return this.discountService.getDiscountService();
	}

	public String getBrandName() {
		return null;
	}

}
