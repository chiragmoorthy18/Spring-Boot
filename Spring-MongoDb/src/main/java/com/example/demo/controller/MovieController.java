package com.example.demo.controller;

import java.awt.List;
import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.MovieRequestDTO;
import com.example.demo.DTO.PersonDTO;
import com.example.demo.Document.Movie;
import com.example.demo.Document.Person;
import com.example.demo.service.MovieService;
import com.example.demo.service.PersonService;

@RestController
public class MovieController {
    
	MovieService movieService;
	PersonService personService;
    @Autowired
	public MovieController(MovieService movieService,PersonService personService) {
		super();
		this.movieService = movieService;
		this.personService = personService;
	}
    
//    add person to db takes Person request entity as Request body
    @PostMapping("person") ResponseEntity<?> addPerson(@RequestBody PersonDTO personDTO)
    {  
    	Person person = new Person(personDTO.getName(), personDTO.getAge(), personDTO.getGender());
    	this.personService.addPerson(person);
    	return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }
    
    
    @PostMapping("movie")
    public ResponseEntity<?> addMovie(@RequestBody MovieRequestDTO movieRequestDTO,@RequestHeader String uuids,@RequestHeader String directorUuid)
    {   
     
    	String[] uuidArray= uuids.split(",");
    	java.util.List<Person> personList = new ArrayList<Person>();
    	for(String id: uuidArray)
    	{
    		personList.add(this.personService.findByUuid(id));
    	}
    	Person director = this.personService.findByUuid(directorUuid);
    	Movie movie = new Movie(movieRequestDTO.getName(), movieRequestDTO.getRating(), personList, movieRequestDTO.getGenre(),director);
    	this.movieService.addMovie(movie);
    	System.out.println("movie added");
    	return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }
    
    @GetMapping("getCast")
    public ResponseEntity<java.util.List<Person>> getCast(@RequestHeader String uuid)
    {
    	return ResponseEntity.ok().body(this.movieService.findCast(uuid));
    }
    
    @GetMapping("getMoviesByDirector/{dUuid}")
    public ResponseEntity<?> findMoviesByDirector(@PathVariable String dUuid)
    {   
    	Person director = this.personService.findByUuid(dUuid);
    	return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.movieService.findMoviesByDirector(director));
    }
    
    @GetMapping("getMovieStarring/{aUuid}")
    public ResponseEntity<?> findMovieStarring(@PathVariable String aUuid)
    {   
    	Person actor = this.personService.findByUuid(aUuid);
    	System.out.println(actor);
    	return ResponseEntity.status(HttpStatus.OK).body(this.movieService.findMoviesStarring(actor));
    	
    }
    
    
	
}
