package com.akagami.api.config;

import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

public class MongoConfig extends AbstractMongoClientConfiguration{

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "employee_system";
	}

}
