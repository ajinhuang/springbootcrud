package com.jin.springcrud.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jin.springcrud.entity.Person;
import com.jin.springcrud.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonRestController {
	private PersonService personService;
	// quick injection, will modify later
	
	@Autowired
	public PersonRestController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping("/persons")
	public List<Person> havePersonList() {
		return personService.findAll();
	}
	
	@GetMapping("/persons/{id}")
	public Person getById(@PathVariable int id) {
		return personService.findById(id);
	}
	
	@PostMapping("/persons")
	public Person addAPerson(@PathVariable Person person) {
		person.setId(0);
		personService.save(person);
		return person;
	}
	
	// to update, user should specify the id field
	@PutMapping("/persons/{id}")
	public Person updatePerson(@PathVariable Person person) {
		personService.save(person);
		return person;
	}

}
