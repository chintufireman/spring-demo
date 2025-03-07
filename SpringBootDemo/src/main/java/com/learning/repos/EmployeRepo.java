package com.learning.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entities.Employe;

@Repository
public interface EmployeRepo extends JpaRepository<Employe, Integer>{
	
	public Employe findByName(String name);
}
