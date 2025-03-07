package com.learning.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.learning.entities.Employe;
import com.learning.exceptions.ResourceNotFoundException;
import com.learning.repos.EmployeRepo;
import com.learning.services.EmployeService;
import com.learning.services.EmployeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	EmployeRepo employeRepo;

	@InjectMocks
	EmployeServiceImpl employeService;

	@Test
	public void getAllEmployesTest() {
		List<Employe> allEmployes = employeService.getAllEmployes();
		System.out.println(allEmployes);
	}

	@BeforeAll
	public static void init() {
		System.out.println("Employee testing started...");
	}

	static int counter = 0;

	@BeforeEach
	public void initEachTest() {
		counter++;
		System.out.println("Testing test case number " + counter);
	}

	@Test
	public void saveEmployesTest() {
		Employe employe = new Employe();
		employe.setId(1);
		employe.setName("harshwardhan");
		employe.setSalary(1000);
		Mockito.when(employeRepo.save(employe)).thenReturn(employe);
		// to tell mockito what to do conditionally when this function
		// is called also called as mocking ur calls
		Employe saveEmploye = employeService.saveEmploye(employe);
		Assertions.assertNotNull(saveEmploye);
		Assertions.assertEquals(employe.getId(), saveEmploye.getId());
	}
	//testing of void methods
	@Test
	public void deleteEmployeTest() {
		
		Mockito.doNothing().when(employeRepo).deleteById(1);
		//tells that this method does not return anything
		
		employeService.deleteEmploye(1);
		Mockito.verify(employeRepo,times(1)).deleteById(1);
		//1st paramter takes repo
		//2nd takes verification mode or how many times
		//the method invocation should be checked 
		//and after this we chain method which needs to 
		//be check how many times its invoked
	}
	
	//testing of private method
	@Test
	public void validateEmpNameTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Employe employe = new Employe();
		employe.setId(1);
		employe.setName("harshwardhan");
		employe.setSalary(1000);
		
		//all of this process is to get method here
		//1st pass method name 2nd pass what type argument it takes
		Method declaredMethod = EmployeServiceImpl.class
		.getDeclaredMethod("validateEmpIfPresent", Employe.class);
		
		//to make this method accessible
		declaredMethod.setAccessible(true);
		//and this is to invoke it
		Employe invoke = (Employe)declaredMethod
				.invoke(employeService, employe);
		
		Assertions.assertTrue(invoke!=null);
	}
	
	
	//testing exception 
	@Test
	public void testIfResourceNotFoundExceptionWorks() {
		RuntimeException exception = assertThrows(RuntimeException.class, ()->{
			employeService.saveEmploye(new Employe());
		});
		assertEquals("Empty employee passed",exception.getMessage());
	}
	
	@AfterEach
	public void cleanUp() {
		System
		.out
		.println("After execution of " + counter + 
				" test case we decrement ");
		
	}
	
	@AfterAll
	public static void destroy() {
		System.out.println("destroying all class level data");
	}
}
