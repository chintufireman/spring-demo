### what is bean tag?

1. when u write in normal java like this Student s1 = new Student() then it is called as Object 

2. the same thing that is done in spring is called as Bean

### ways to inject bean inside a class

1. understand the flow inside the bus class u have to use reference variable of DiscountService interface so that u can access its method getDiscount() so for that u have initialized its variable by creating Object of its implementation class

2. whose object of implementation class is created by using spring , we will create at runtime by configuring xml file and defining bean tag inside it

3. but we have to throw this reference variable inside the Bus class which we haven't done

4. there are 3 ways to do it a) constructor injection b) setter injection c) property injection

5. now lets do it using constructor injection so this will be done by creating constructor of the bus class and initialize discountservice reference.

6. so using constructor we will initialize object of DiscountService reference 

7. we pass bean of discountService interface in bean of myVehicle so that it will know that we have to inject this bean in our bean

8. using contructor-arg and providing id of discountservice bean in reference attribute of tag

9. another way is setter injection same above way only in config file we will provide property tag in which we will give name which is reference variable name we used in bus class to define it and another is reference id of bean which we created of mydiscountservice now the flow will be same as constructor one to inject bean.

10. remember u have to create setter for reference variable of discountservice in bus class

### How to inject literals

1. literals mean in class u have created a String, int, boolean, etc variables and u will need them to instantiate too.

2. one way is using setter injection and defining property tag in xml.

3. another way is to create properties file in resource folder
create any key value pair like bus.mrp=2000 doesnt matter.

4. now just import that property file in xml and after same tag but instead of providing raw manual value do ${bus.mrp}

### how to change scopes of bean?
1. inside bean tag use scope attribute and change the scope of bean by mentioning it as a value

2. by default it is singleton