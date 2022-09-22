package com.akagami.api.model;



import org.bson.types.Binary;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Post {

//	public Post(String id, String strPost, String name2, String email2, MultipartFile file2,
//			MultipartFile profilePic2, String strtimeStamp) {
//		// TODO Auto-generated constructor stub
//		this.id=id;
//		this.post=strPost;
//		this.name=name2;
//		this.email=email2;
//		this.image=file2;
//		this.profilePic=profilePic2;
//		this.timeStamp=timeStamp;
//	}
	private String id;
	private String post;
	private String name;
	private String email;
	private MultipartFile image;
//	private MultipartFile profilePic;
	private String timeStamp;
	
}
