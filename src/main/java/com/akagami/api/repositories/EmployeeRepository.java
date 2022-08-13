package com.akagami.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.akagami.api.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String>{
	@Query("{ 'firstName' : ?0 }")
	public List<EmployeeEntity> findByFirstName(String firstName);

	public List<EmployeeEntity> findByLastName(String lastName);
}
