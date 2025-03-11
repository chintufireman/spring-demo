package com.learning.dbconnections;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "nosqlconnection"
			, value ="enabled"
			, havingValue = "create"
			, matchIfMissing = false)

public class NoSqlConnection {

	public NoSqlConnection() {
		System.out.println("No sql connection created...");
	}

}
