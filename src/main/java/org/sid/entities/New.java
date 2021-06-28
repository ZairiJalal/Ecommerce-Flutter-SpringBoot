package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class New implements Serializable{
	
	@Id
	private String _id;
	private String title;
	private String description;
	private Date date= new Date();
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private byte[] image;
	private String imageUrl;
	private String categorie;
	private String author;

}
