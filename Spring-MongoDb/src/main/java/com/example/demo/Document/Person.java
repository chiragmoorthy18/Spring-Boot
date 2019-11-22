package com.example.demo.Document;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person { 
	String pUuid;
	String name;
	String age;
	String gender;
	
	public Person(String name, String age, String gender) {
		super();
		this.pUuid = UUID.randomUUID().toString();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
}
