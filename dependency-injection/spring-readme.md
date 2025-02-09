### how to create spring project
1. select new maven project and tick simple project in eclipse enter all details like group-id and etc and finish it.
2. go to google and search maven spring core and spring context

### ioc container
1. now after installing spring whenever u want any object in the project u will not do it in Myapp main method u will tell to spring bring the object of specific configuration
2. inside spring there is ioc container which does this job which is contacted  by ur Myapp which will contact with configuration.
3. ioc container is responsible to instantiate,configure and assemble object whose information is taken from configuration file.
4. can be done with xml, annotation or java configuration file
5. its name ioc inversion of control is given because generally what u do is u run commands sequentially, then u maintain control over the flow of program.
6. inversion of control flips it your program does not control the flow of program rather than calling commands as u see fit u wait for someone else to call u.
7. the last line is important rather than calling someone else when u feel like it someone else calls u when they feel like it

### what is application context?
1. there are two types of ioc container Beanfactory and ApplicationContext

2. BeanFactory is most basic and simple ioc container and ApplicationContext is advanced and more featured container.

3. both are ways to implement ioc container or they are ioc container

### what is dependency Injection?
1. dependency means suppose u have 2 classes car and bus and lets say both of this classes are dependent on vehicle class then its called as dependency

2. when u inject these dependencies then it is called as dependency injection

3. lets take eg:- u cretead a discountservice interface in which u add functionality to get discount message.

4. now u want to use this functionality in car and bus so u have to implement this interface. like u are doing in myspringapp file vehicle.getMilage() same u have to do vehicle.getDiscountMessage()
and currently the vehicle is of type bus or configured as bus.

5. but that discount message is written in different interface or in different service. so we have to use reference of discountservice interface inside the bus which makes bus dependent on discountservice or helper service.

6. so what u have to do in main class now using vehicle call getDiscountMessage() for that u have to create one method inside the vehicle interface and make them implement in bus and car class

7. at first it will give nullpointer exception after calling discountservice() from myspringapp because inside the Bus or Car class u haven't initialized the DiscountService variable.

### flow of how dependency injection is happening

1. first our spring app -> call ioc container -> go to ApplicationContext -> go to config.xml file -> getBean or simply get object of Vehicles implementation class -> config file checks for bean defination of Bus --> inside that there is constructor-arg which will tell config that we have to call constructor of Bus class -> now it will search the reference or id of provided bean inside the constructor arg throughout the whole file -> it will get Bean of DiscountService with id myDiscountService -> inject this by providing value in arguments of constructor -> and return object or bean of Bus.

2. same for setter injection as well though in xml file we define how to inject the dependent bean by using using property tag.