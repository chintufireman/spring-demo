### testing with junit

1. You can test any service in spring boot using @Test above the method which u created in ur test classes
2. When u want to use ur services inside the test classes u have 2 ways to do this
3. first u can annotate ur class with `@SpringBootTest` second u can use Mockito in ur test classes to mock ur services
4. By using `@SpringBootTest` you can inject ur beans without running the whole spring application context, but this takes lots of time to do this
5. we use `@mock` for creating fake beans or mock our services and then use it
6. U will have to annotate ur class with `@ExtendWith(MockitoExtension.class)` to enable use of mockito 
7. if u want to inject repository inside the service then u have to create reference variable of EmployeRepo and @Mock it and use `@InjectMocks` on Service so that ur mocks are injected inside the service.

### passing entities to repo for save function

1. if u are using save function simply and as u know u will need entity to save that data employee data in db and get same saved object in return, for that u can use `Mockito.when(employeRepo.save(employe)).thenReturn(employe)`
which is nothing but a function or way to tell mockito what to do when some function is being called, this is also called as mocking ur bean.


### Test Life cycle

1. `@BeforeAll` lets say before execution of all the tests in test class we do some setup. so the method which is annotated with  `@BeforeAll` . will be executed first in test class. this method should be static as it will be executed only once.

2. `@BeforeEach` this lifecycle will be executed before each test cases is executed . this is used for creating test surrounding, there might be some dynamic objects which test method might depend on it.

3. after above 2 `@Test`  is executed

4. `@AfterEach` is executed after the execution of each test cases lets say u have to reset some variables after execution of each test then u can use this.

5. `@AfterAll` is called after the execution of all test cases. like destroying db connection


### Mocking void methods by using doNothing() and verify()
1. lets suppose u have service that does not return anything so how will u know if the test case is executed successfully 

2. u use `Mockito.verify(employeRepo,times(1)).deleteById(1);` to verify if this method is called 1 time. 2nd parameter of verify takes verification mode or how many times method invocation should be cheked in above case one

3. after that we mentioned which method needs to be checked for invocation.

4. after this we have to tell test method that called repository will not return anything `Mockito.doNothing().when(employeRepo).deleteById(1);` tells that this method will not return anything after invocation.

### testing private method

1. first way is to make use of that private in some public method and then test that public java method 
2. second way for purely testing through methods is by using java reflections.
3. get method using reflection api then set its accessibility to true and then invoke that function just thats it

### testing exceptions
1. u have to use assertThrows
2. mention the exception which u are expecting inside the assert throws and then give lambda function inside it
