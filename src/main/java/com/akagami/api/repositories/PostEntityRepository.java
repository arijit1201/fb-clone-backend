package com.akagami.api.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.akagami.api.entity.PostEntity;

@Repository
public interface PostEntityRepository extends MongoRepository<PostEntity, String>{
	@Query("{ 'firstName' : ?0 }")
	public List<PostEntity> findByFirstName(String firstName);

	public List<PostEntity> findByLastName(String lastName);
}
