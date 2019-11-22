package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Document.Movie;
@Repository
public interface MovieRepositary extends MongoRepository<Movie, String> {
  
}
