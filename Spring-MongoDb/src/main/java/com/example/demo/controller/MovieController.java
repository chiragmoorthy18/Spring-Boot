package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Document.Movie;
import com.example.demo.service.MovieService;

@RestController
public class MovieController {
    
	MovieService movieService;
    @Autowired
	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
    
    @PostMapping("movie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie)
    {
    	this.movieService.addMovie(movie);
    	System.out.println("movie added");
    	return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }
	
}
