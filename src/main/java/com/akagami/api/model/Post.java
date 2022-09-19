package com.akagami.api.model;



import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {

	private String id;
	private String post;
	private String name;
	private String email;
	private MultipartFile image;
	private MultipartFile profilePic;
	private String timeStamp;
	private String file;
	
}
