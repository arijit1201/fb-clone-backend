package com.akagami.api.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api/v1/post", consumes="multipart/form-data")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@PostMapping
	public PostEntity addPost( @RequestParam(value = "image", required = false) MultipartFile image, @RequestParam("data") String data) throws IOException {
		String jsonString 
        = new ObjectMapper().readTree(data).asText("");
		JsonNode node = new ObjectMapper().readTree(jsonString);
		String strPost = node.get("post").asText();
		String email = node.get("email").asText();
		String name = node.get("name").asText();
		String profilePic = node.get("profile").asText();
		
		PostEntity post = PostEntity.builder()
				.email(email)
				.post(strPost)
				.name(name)
				.profilePic(profilePic)
				.build()
				;
		System.out.println(image);
		if(image!=null && image.getSize()>0)
			post.setImage((new Binary(BsonBinarySubType.BINARY,image.getBytes())));
		else post.setImage(null);
		
		PostEntity result = service.addPost(post);
		//result.setImgRes(Base64.getEncoder().encodeToString(new Binary(BsonBinarySubType.BINARY,image.getBytes()).getData()));
		return result;
	}
	
	
//	@PostMapping("/v2")
//	public PostEntity addPost2( @RequestParam Map<String,String> requestParams) throws IOException {
//		requestParams.entrySet().stream().forEach(entry -> System.out.println("key : "+entry.getKey() + " value : "+ entry.getValue()));
//		String jsonString 
//        = new ObjectMapper().readTree(requestParams.get("data")).asText("");
//		JsonNode node = new ObjectMapper().readTree(jsonString);
//		String strPost = node.get("post").asText();
//		String email = node.get("email").asText();
//		String name = node.get("name").asText();
//		//System.out.print(requestParams.get("profile"));
//		PostEntity post = PostEntity.builder()
//				.email(email)
//				.post(strPost)
//				.name(name)
//				.build()
//				;
////		System.out.println(image);
////		if(image!=null && image.getSize()>0)
////			post.setImage((new Binary(BsonBinarySubType.BINARY,image.getBytes())));
////		else post.setImage(null);
////		if(profilePic!=null && profilePic.getSize()>0)
////			post.setProfilePic(new Binary(BsonBinarySubType.BINARY,profilePic.getBytes()));
////		else post.setProfilePic(null);
////		MultipartFile file = requestParams.get("file");
////		MultipartFile profilePic = requestParams.get("profilePic");
//		PostEntity result = new PostEntity(); //service.addPost(post);
//		result.setImage(null);
//		result.setProfilePic(null);
//		return result;
//	}
	
	@GetMapping(consumes = MediaType.ALL_VALUE)
	public List<PostEntity> getAllEmployees(){
		return service.getPosts();
	}
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
