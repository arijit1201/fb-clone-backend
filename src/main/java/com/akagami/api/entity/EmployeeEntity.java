package com.akagami.api.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity implements Serializable{
	@Id
	private String id;
	private String firstName;
	private String lastName;
	@Indexed(unique = true)
	@Field("email")
	private String emailId;
	
	public EmployeeEntity(String firstName, String lastName, String emailId)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.emailId=emailId;
	}
	
}
