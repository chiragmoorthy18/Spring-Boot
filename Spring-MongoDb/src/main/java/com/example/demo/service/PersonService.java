package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Document.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
     
	private PersonRepository personRepository;
    @Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}
    
    
    public void addPerson(Person person)
    {
    	this.personRepository.insert(person);
    }
    
	
}
