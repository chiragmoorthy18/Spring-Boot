package com.example.demo.Document;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Movie { 
	
	String uuid;
	String name;
	float rating;
	List<Actor> cast;
	String genre;
	
  
}
