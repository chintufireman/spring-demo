### Configuration annotation
1. if u have to completely remove xml config from ur spring project then use 
this annotation
2. like currently u are using <context:component-scan> inside the xml file
to scan beans in spring project but this can also be removed using java config file
3. use @Configuration and @ComponentScan
4. if u write @Configuration above java file spring wont go to xml and instead of that it will go to this java class to create beans
5. As u write component-scan attribute inside the bean tag in xml u have to write here @ComponentScan tag and mention the base package to search for component annotation and create its bean.

6. Instead of writing ClassPathXmlApplicationContext to get context u use here in main class  

### @Bean annotation
1. generally if u dont want to define bean in xml you annotate class with @Component.
2. You can also defines beans inside the config.java file just like how we used to create it in xml file.
3. you create a method which returns the object of car or vehicle u annotate that method with @Bean. 
4. to get bean from context u provide name of bean which is in this case is simply method's name.
5. if u want to inject a bean inside another bean like reference of another class. you must first create the referenced class as bean using @Component or @Bean in config.java file
6. you can inject bean using field inject, constructor and setter injection.
7. for field simple use autowire if for constructor and setter injection create methods inside the config.java class and pass the @Bean of DiscountService as a parameter by providing method's name in parameter

### property injection
1. when u want to inject some values inside the variable through .properties file what u did is u mentioned the property file name inside the <context:property-placeholder location ="bus.properties"/> tag.
2. but to do it wihtout importing it in xml u simply use @PropertySource below @Configuration annotation and import the file there