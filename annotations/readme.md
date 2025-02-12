### Component annotation

1. either u can use @Component("car") by mentioning id as car or without it as by default the spring converts the class name's first letter to small so Car class's bean will have id car or if it was CarService then its id will be carService.

2. But suppose if u created Impl class with Name  WWEServiceDiscount then its id wont be wWEServiceDiscount by default, its id will be same name as class name WWEServiceDiscount by default if u pass id then it will have that id.

### autowired annotation

1. it is a annotation for Dependency injection
2. whenever u want to inject dependency inside the class then we will use autowired annotation.
3. spring will scan class or interface where we have written autowired. 
4. suppose u are using autowire on constructor then the parameters passed in arguments of constructor its interface or implementation class will be scanned throughout package which we have mentioned in xml file must be scanned for this impl class or interface.
5. same in component annotation's case also works to search in entire package for interface or its impl class. 

### qualifier annotation
1. suppose u created interface discountservice and it has 2 implementation class 1 is FestivalDiscountService and another is NoDiscountService both implement same interface.

2. Now during runtime u want to intialize discountService refernce with Impl class but it has 2 impl class. 

3. in this case we use @Qualifier annotation and inside that we pass the id of bean. and that's it. use this annotation above the dependency on which u have used autowire annotation.

4. the syntax is same for field and setter injection case use annotation below autowire but in constructor injection case we pass @qualifier as a argument.
public Car(@Qualifier("noDiscountServiceImpl") DiscountService discountService) {}

### value annotation

1. it is used for property injection from property file.
2. we first pass the location of property file its name inside the xml file context:property-placeholder tag.
3. and simply use the @value annotation on variable where u want to inject property from file and with same syntax used in xml to inject property inside @Value("${car.mrp}") pass name of property
