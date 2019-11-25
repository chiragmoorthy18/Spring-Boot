package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.microservice.Movie;
import com.example.demo.service.UserService;
import com.example.demo.userProfile.UserProfile;

@RestController
public class UserController {
    
	private UserService userService;
	private Movie movie;
	  
	@Autowired
    public UserController(UserService userService,Movie movie) {
		super();
		this.userService = userService;
		this.movie = movie;
	}


	@PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody UserRequestDTO userRequestDTO)
    {   
		boolean isDuplicateUser,isValidUsername;
		isDuplicateUser = this.userService.validateDuplicateUser(userRequestDTO.getEmail());
		isValidUsername = this.userService.uniqueUsername(userRequestDTO.getUsername());
		if(isDuplicateUser)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exist");
		}
		else if(!isValidUsername)
		{
			return ResponseEntity.status(HttpStatus.CONFLICT).body("username exist!!! try another username");
		}
		
    	UserProfile  userProfile = new UserProfile(userRequestDTO.getName(), userRequestDTO.getEmail(), userRequestDTO.getUsername(), userRequestDTO.getPassword());
    	
    	
    	return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.userService.addUser(userProfile));
    }
	
	@GetMapping("addWatchlist/{userUuid}")
	public ResponseEntity<?> addWatchlist(@RequestHeader(defaultValue = "") String movieIds,@PathVariable String userUuid)
	{
		String[] movieUuids = movieIds.split(",");
		List<com.example.demo.Document.Movie> movieList = new ArrayList<>();
		for(String uuid:movieUuids)
		{
			com.example.demo.Document.Movie movie = this.movie.findByUuid(uuid);
			
			movieList.add(movie);
		}
		
		UserProfile userProfile = this.userService.findByUuid(userUuid);
		userProfile.setList(movieList);
		this.userService.updateUser(userProfile);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userProfile);
		
	}
	
	

	
}
