package com.akagami.api.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akagami.api.entity.PostEntity;
import com.akagami.api.model.Post;
import com.akagami.api.repositories.PostEntityRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostEntityRepository repository;
	private static final Logger log = Logger.getLogger(PostServiceImpl.class.getName());

	@Override
	public Post addPost(Post post) {
		try {
			PostEntity postEntity = new PostEntity();
			BeanUtils.copyProperties(post, postEntity);
			
			if(post.getFile() != null && !post.getFile().equalsIgnoreCase("null"))
			{
				postEntity.setImage(post.getFile());
			}
			else postEntity.setImage(null);
				
			
			postEntity = repository.save(postEntity);
			post.setId(postEntity.getId());
			post.setFile(null);
			post.setImage(postEntity.getImage());
			log.info(postEntity.toString());
		} catch (Exception e) {
			log.severe("Exception occured: " + e.getMessage());
			return null;
		}
		return post;
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
