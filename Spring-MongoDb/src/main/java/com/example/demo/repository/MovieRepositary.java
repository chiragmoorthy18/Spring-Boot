package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Document.Movie;
import com.example.demo.Document.Person;
@Repository
public interface MovieRepositary extends MongoRepository<Movie, String> {
   
	
	@Query("{uuid: ?0}")
	public Optional<Movie> findById(String id);
	
	public List<Movie> findAllByDirector(Person director);
	
	@Override
	public List<Movie> findAll();
}
