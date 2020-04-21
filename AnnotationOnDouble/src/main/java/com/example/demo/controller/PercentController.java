package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.PercentPojo;
import com.example.demo.repository.PercentRepository;

import lombok.NoArgsConstructor;

@RestController
public class PercentController { 
	@Autowired
	private PercentRepository percentRepository;
	
	@PostMapping("/insertPercent")
	private ResponseEntity<?> postPercentPojo(@RequestBody @Valid PercentPojo percentPojo) {
		
		percentRepository.insert(percentPojo);
		
		return ResponseEntity.ok().body(percentRepository.findAll());
	}
	

}
