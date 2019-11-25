package com.example.demo.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Document.Actor;
import com.example.demo.Document.Movie;
import com.example.demo.Document.Person;
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
	
    public List<Person> findCast(String uuid)
    {
    	Movie movie= this.movieRepositary.findById(uuid).get();
    	
    	List<Person> cast = movie.getCast();
    	
    	return cast;	
    	
    }
    
    public List<Movie> findMoviesByDirector(Person director)
    {
    	return this.movieRepositary.findAllByDirector(director);
    }
    
    public List<Movie> findMoviesStarring(Person actor)
    {   
    	System.out.println("Inside movies starring");
    	List<?> tempMovies= this.movieRepositary.findAll();
    	System.out.println(tempMovies);
    	List<Movie> movies = new ArrayList<Movie>();
    	for(Object moviesObj:tempMovies)
    	{ 
    		if(moviesObj instanceof Movie)
    		{
    			Movie movie = (Movie)moviesObj;
    			List<?> cast = movie.getCast();
        		for(Object castMember:cast)
        		{  if(castMember instanceof Person)
    	    		{   Person cas = (Person)castMember;
    	    			if(cas.getPUuid().equals(actor.getPUuid()))
    	    			{  System.out.println(movie);
    	    				movies.add(movie);
    	    			}
    	    		}	
        		}
    		}
    		
    	}
    	
    	return movies;
    }
    
    public Movie findByUuid(String uuid)
    {
    	return this.movieRepositary.findById(uuid).get();
    }
	


}
