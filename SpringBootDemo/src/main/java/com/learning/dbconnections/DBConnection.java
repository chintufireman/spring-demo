package com.learning.dbconnections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DBConnection {
	
	//optional maybe bean created or not 
	@Autowired(required = false) 
	private SqlConnection sqlConnection;
	
	@Autowired(required = false)
	private NoSqlConnection noSqlConnection;
	
	@PostConstruct
	public void init() {
		System.out.println("Db connection init..");
		System.out.println("Mysqlconnection "+sqlConnection);
		System.out.println("Nosqlconnection "+noSqlConnection);
	}
}
