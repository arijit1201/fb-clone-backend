package com.akagami.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.akagami.api.entity.PostEntity;
import com.akagami.api.model.Post;

public interface PostService {

//	Post createEmployee(Post employee);
//
//	List<Post> getAllEmployees();
//
//	boolean deleteEmployee(String id);
//
//	Post getEmployee(String id);
//
//	Post updateEmployee(String id, Post employee);

	PostEntity addPost(PostEntity post);

	List<PostEntity> getPosts();

}
