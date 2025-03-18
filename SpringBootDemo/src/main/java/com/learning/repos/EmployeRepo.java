package com.learning.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.entities.Employe;

@Repository
public interface EmployeRepo extends JpaRepository<Employe, Integer>{
	
	public List<Employe> findByName(String name);
	//public List<Employe> findByNameAndSalary(String name,double salary);
	public List<Employe> findBySalaryOrderByNameAsc(double salary);
	
	@Query("select e from Employe e where e.name LIKE %:name%")
	public List<Employe> findEmployeByPartialName(@Param("name") String name);
}
