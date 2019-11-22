package com.example.demo.DTO;

import java.util.List;

import com.example.demo.Document.Person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequestDTO {
    
	String name;
	float rating;
	String genre;
}
