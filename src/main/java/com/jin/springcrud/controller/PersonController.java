package com.jin.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jin.springcrud.entity.Person;
import com.jin.springcrud.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	@Autowired
	PersonService personService; 
	// CRUD processes
	
	
	@GetMapping("/list")
	public String listAll(Model theModel) {
		List<Person> allPersons= personService.findAll();
		theModel.addAttribute("allPersons", allPersons);
		return "/persons/person-list";
	}
	
	@GetMapping("/register")
	public String showAddPersonForm(Model theModel) {
		Person newPerson= new Person();
		
		theModel.addAttribute("person", newPerson);
		return "/persons/add-new-person";
	}
	
	@PostMapping("/save")
	public String processFormData(@ModelAttribute("person") Person person) {
		// save the person
		personService.save(person);
		return "redirect:/person/list";
	}
	
	@GetMapping("update")
	public String showUpdateForm(@RequestParam("personId") int theId, Model theModel) {
		//get the person from the service
		Person thePerson= personService.findById(theId);
		
		theModel.addAttribute("person", thePerson);
		return "/persons/update-form";
	}
	
	@GetMapping("delete")
	public String deleteAPerson(@RequestParam("personId") int theId, Model theModel) {
		//get the person from the service
		personService.deleteById(theId);
		return "redirect:/person/list";
	}
}
