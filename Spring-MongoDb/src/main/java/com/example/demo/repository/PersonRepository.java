package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Document.Person;
@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
	@Query("{pUuid : ?0}")
    Optional<Person> findByPUuid(String pUuid);
}
