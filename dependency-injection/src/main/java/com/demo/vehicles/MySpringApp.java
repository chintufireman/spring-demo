package com.demo.vehicles;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext
			= new ClassPathXmlApplicationContext("config.xml");
		
//	1. this class path xml application context providing us 
//	application context which will bring for my car or bus
	
//	2. flow will be like this
//	our code -> ioc container -> applicationcontext -> config.xml
//	
//	3. we will provide there in config.xml file 
//	bean tag lets go there and see what is bean
		
//	4. we have configured bean in xml file for vehicle object 
//	lets see how to use it
		
	Vehicle bean = 
			applicationContext.getBean("myVehicle", Vehicle.class);
//	u provide the id of bean and the class in which it needs to 
//	be casted it into
		System.out.println(bean.getMilage());
		
//	when code gets bigger then this thing will be important
//	if u have to change vehicles behaviour from bus to 
//	car then simply change bean definiation in config file
		
		System.out.println(bean.getDiscount());
//		 java.lang.NullPointerException:
//		at first the above exception will occur because u haven't
//		intialized DiscountService inside the Bus or Car class
		System.out.println(bean.getBrandName());
		System.out.println(bean.getMaxPrice());
	}
}
