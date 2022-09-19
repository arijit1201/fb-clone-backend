package com.akagami.api.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.akagami.api.entity.PostEntity;
import com.akagami.api.model.Post;
import com.akagami.api.service.PostService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/post")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@PostMapping
	public Post addPost(@RequestBody Map<String, String> requestParams, @RequestParam MultipartFile file, @RequestParam MultipartFile profilePic) {
		String strPost = requestParams.get("post");
		String email = requestParams.get("email");
		String name = requestParams.get("name");
//		MultipartFile file = requestParams.get("file");
//		MultipartFile profilePic = requestParams.get("profilePic");
		System.out.println("sd");
		Post post = new Post(strPost,);
		post = service.addPost(post);
		return post;
	}
	
//	@GetMapping("/employees")
//	public List<Post> getAllEmployees(){
//		return service.getAllEmployees();
//	}
//	
//	@DeleteMapping("/employee/{id}")
//	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable String id)
//	{
//		boolean deleted = false;
//		deleted = service.deleteEmployee(id);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", deleted);
//		return ResponseEntity.ok(response);
//	}
//	
//	@GetMapping("/employee/{id}")
//	public ResponseEntity<Post> getEmployee(@PathVariable String id)
//	{
//		Post employee = new Post();
//		employee = service.getEmployee(id);
//		return ResponseEntity.ok(employee);
//	}
//	
//	@PutMapping("/employee/{id}")
//	public ResponseEntity<Post> updateEmployee(@PathVariable String id, @RequestBody Post employee) {
//		employee =service.updateEmployee(id, employee);
//		return ResponseEntity.ok(employee);
//	}

}
