package com.learning.dbconnections;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "sqlconnection"
	, value ="enabled"
	, havingValue = "create"
	, matchIfMissing = false)

public class SqlConnection {

	public SqlConnection() {
		System.out.println("Sql connection created");
	}

}
