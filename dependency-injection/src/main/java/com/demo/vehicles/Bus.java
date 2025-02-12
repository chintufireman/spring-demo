package com.demo.vehicles;

public class Bus implements Vehicle{

	DiscountService discountService;
	String brandName;
	double maxPrice;
	
	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Bus(DiscountService discountService) {
		this.discountService = discountService;
	}

	public Bus() {
		
	}
	
	public void setDiscountService(DiscountService discountService) {
		this.discountService = discountService;
	}

	public int getMilage() {
		// TODO Auto-generated method stub
		return 8;
	}

	public String getDiscount() {
		// TODO Auto-generated method stub
		return discountService.getDiscountService();
	}
	
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandName() {
		return brandName;
	}

}
