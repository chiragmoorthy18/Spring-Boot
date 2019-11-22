package com.example.demo.Document;
import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Movie { 
	
	String uuid;
	String name;
	float rating;
	List<Person> cast;
	Person director;
	String genre;
	
	public Movie(String name, float rating, List<Person> cast, String genre,Person director) {
		super();
		this.uuid = UUID.randomUUID().toString();
		this.name = name;
		this.rating = rating;
		this.cast = cast;
		this.genre = genre;
		this.director = director;
	}
	
	
  
}
