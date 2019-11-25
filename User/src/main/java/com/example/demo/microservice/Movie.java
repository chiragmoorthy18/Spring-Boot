package com.example.demo.microservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("movie-client-mongo")
@Component
public interface Movie { 
	
	@GetMapping("movie/{uuid}")
    public com.example.demo.Document.Movie findByUuid(@PathVariable String uuid);
	
     
}
