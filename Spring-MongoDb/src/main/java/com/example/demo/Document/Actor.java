package com.example.demo.Document;


import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
public class Actor extends Person {
	
	
	private String characterName;

}
