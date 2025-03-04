package com.learning.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entities.Employe;
import com.learning.exceptions.ResourceNotFoundException;
import com.learning.repos.EmployeRepo;

import jakarta.transaction.Transactional;

@Service
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	private EmployeRepo employeRepo;
	
	@Transactional
	@Override
	public Employe saveEmploye(Employe employe) {
		Employe save = employeRepo.save(employe);
		System.out.println(save.toString());
		return save;
	}

	@Override
	public Employe getEmployee(int id) throws ResourceNotFoundException {
		Employe employe = null;
		
			 employe= employeRepo
					.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("No Such Element found with id "+id));
		
		return employe;
	}

	@Override
	public Employe updateEmploye(Employe employe, int id) {
		
		Employe oldEmp = null;
		try {
			oldEmp = employeRepo
					.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("No such employee with id "+id));
			oldEmp.setName(employe.getName());
			oldEmp.setSalary(employe.getSalary());
			
			oldEmp = employeRepo.save(oldEmp);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return oldEmp;
	}

	@Override
	public void deleteEmploye(int id) {
		try {
			employeRepo
			.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("No such employee found with id "+id));
		}
		catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Employe> getAllEmployes() {
		return employeRepo.findAll();
	}

}
