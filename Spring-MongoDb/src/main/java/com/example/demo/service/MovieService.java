package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Document.Movie;
import com.example.demo.repository.MovieRepositary;

@Service
public class MovieService { 
	MovieRepositary movieRepositary;
    @Autowired
	public MovieService(MovieRepositary movieRepositary) {
		super();
		this.movieRepositary = movieRepositary;
	}
    
    public void addMovie(Movie movie)
    {
    	
    	this.movieRepositary.insert(movie);
    }
	
	
	
	

}
