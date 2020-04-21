package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Director;
import com.example.demo.model.Movie;

@RestController
public class MovieRestController { 
	public static List<Movie> movieList = new ArrayList<Movie>();
	
	
	@PostMapping("/movie")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie)
	{  
		movieList.add(movie);
		Director director = new Director();
		director.setName(movie.getName());
		director.setAge("22");
		director.setUuid(UUID.randomUUID().toString());
		return ResponseEntity.status(204).body(director);
	}
   
	@GetMapping("/status")
	public ResponseEntity<?> status()
	{  
		return ResponseEntity.status(204).body("Rest Controller is working");
		
	}
}
