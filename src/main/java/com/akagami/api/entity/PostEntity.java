package com.akagami.api.entity;

import java.io.Serializable;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("posts")
@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class PostEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4379194636001735580L;
	@Id
	private String id;
	private String post;
	private String name;
	private String email;
	private Binary image;
	private Binary profilePic;
	private String timeStamp;
	private String imgRes;
}
