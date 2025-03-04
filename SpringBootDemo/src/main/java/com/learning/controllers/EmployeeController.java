package com.learning.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entities.Employe;
import com.learning.exceptions.ResourceNotFoundException;
import com.learning.services.EmployeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeService employeService;
	
	@PostMapping
	public ResponseEntity<Employe> save(@RequestBody Employe employe){
		Employe saveEmploye = employeService.saveEmploye(employe);
		return new ResponseEntity<Employe>(saveEmploye, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Employe>> getAll(){
		List<Employe> allEmployes = employeService.getAllEmployes();
		return new ResponseEntity<List<Employe>>(allEmployes,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employe> get(@PathVariable int id) throws ResourceNotFoundException{
		return new ResponseEntity<Employe>(employeService.getEmployee(id), HttpStatus.ACCEPTED);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
			employeService.deleteEmploye(id);
			return 
				new ResponseEntity<String>
			("Employee with id"+id+"is deleted successfully", 
					HttpStatus.ACCEPTED);
	}
}
