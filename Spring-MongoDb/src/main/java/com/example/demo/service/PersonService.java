package com.example.demo.service;

import java.util.Optional;

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
    
//    find person by unique id
    public Person findByUuid(String uuid)
    {
    	Optional<Person> p =this.personRepository.findByPUuid(uuid);
    	if(p.isPresent())
    	{
    		return p.get();
    	}
    	else
    	{
    		return new Person();
    	}
    }
    
	
}
