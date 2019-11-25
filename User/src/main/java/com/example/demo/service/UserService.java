package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.demo.userProfile.UserProfile;


@Service
public class UserService{
	@Autowired
	private UserRepository userRepository;
	
	
	public UserProfile addUser (UserProfile userProfile) 
	{
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		userProfile.setHashedPassword(bCryptPasswordEncoder.encode(userProfile.getPassword()));
		return this.userRepository.insert(userProfile);	
	}
	
	public boolean validateDuplicateUser(String email)
	{
		
		Optional<UserProfile> duplicateUserByEmail=this.userRepository.findByEmail(email);
		if(duplicateUserByEmail.isPresent())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public boolean uniqueUsername(String username)
	{
		Optional<UserProfile> uniqueUser = this.userRepository.findByUsername(username);
		if(uniqueUser.isPresent())
		{
			return false;
		}
		else
		{
			return true;
		}
	
	}
	
	public void updateUser(UserProfile userProfile)
	{
		 this.userRepository.save(userProfile);
	}
	
	public UserProfile findByUuid(String uuid)
	{
		return this.userRepository.findByUuid(uuid).get();
	}
	

}
