package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.PercentPojo;

@Repository
public interface PercentRepository extends MongoRepository<PercentPojo, String> {

}
