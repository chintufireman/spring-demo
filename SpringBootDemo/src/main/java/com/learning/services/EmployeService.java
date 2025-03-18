package com.learning.services;

import java.util.List;

import com.learning.entities.Employe;
import com.learning.exceptions.ResourceNotFoundException;

public interface EmployeService {

	public Employe saveEmploye(Employe employe);
	public Employe getEmployee(int id)throws ResourceNotFoundException;
	public Employe updateEmploye(Employe employe, int id);
	public void deleteEmploye(int id);
	public List<Employe> getAllEmployes();
	
	public List<Employe> getEmpByPartialName(String name);
}
