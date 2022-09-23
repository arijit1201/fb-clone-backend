package com.akagami.api.service;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.akagami.api.entity.PostEntity;
import com.akagami.api.model.Post;
import com.akagami.api.repositories.PostEntityRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostEntityRepository repository;
	private static final Logger log = Logger.getLogger(PostServiceImpl.class.getName());

	@Override
	public PostEntity addPost(PostEntity postEntity) {
		try {

			postEntity.setTimeStamp(new Date().toString());
			postEntity = repository.save(postEntity);
			log.info(postEntity.toString());
			return postEntity;
			
			
		} catch (Exception e) {
			log.severe("Exception occured: " + e.getMessage());
			
		}
		return null;
	}

	@Override
	public List<PostEntity> getPosts() {
		// TODO Auto-generated method stub
		List<PostEntity> posts = repository.findAll();
		Collections.sort(posts, Collections.reverseOrder());
		return posts;
	}

//	@Override
//	public List<Post> getAllEmployees() {
//		return repository.findAll().stream()
//				.map(emp -> new Post(
//						emp.getId(),
//						emp.getFirstName(), 
//						emp.getLastName(), 
//						emp.getEmailId()))
//				.collect(Collectors.toList());
//
//	}
//
//	@Override
//	public boolean deleteEmployee(String id) {
//		try {
//			PostEntity employee = repository.findById(id).get();
//			repository.delete(employee);
//			return true;
//		}
//		catch(Exception e)
//		{
//			log.info("No employee found with id: "+id);
//		}
//		return false;
//	}
//
//	@Override
//	public Post getEmployee(String id) {
//		try {
//			PostEntity employee = repository.findById(id).get();
//			return new Post(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmailId());
//		}
//		catch(Exception e)
//		{
//			log.info("No employee found with id: "+id);
//		}
//		return null;
//	}
//
//	@Override
//	public Post updateEmployee(String id, Post employee) {
//		try {
//			PostEntity employeeEntity = new PostEntity(id, employee.getFirstName(), employee.getLastName(), employee.getEmailId());
//			employeeEntity = repository.save(employeeEntity);
//			return new Post(employeeEntity.getId(), employeeEntity.getFirstName(), employeeEntity.getLastName(), employeeEntity.getEmailId());
//		}
//		catch(Exception e)
//		{
//			log.info("No employee found with id: "+id);
//		}
//		return null;
//	}

}
