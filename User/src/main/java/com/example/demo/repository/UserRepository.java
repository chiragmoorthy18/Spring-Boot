package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.userProfile.UserProfile;

@Repository
public interface UserRepository extends MongoRepository<UserProfile, String> {
   
	Optional<UserProfile> findByEmail(String email);
	Optional<UserProfile> findByUsername(String username);
	Optional<UserProfile> findByUuid(String uuid);
	
	
	
}
