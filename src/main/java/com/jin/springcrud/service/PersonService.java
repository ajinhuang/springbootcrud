package com.jin.springcrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jin.springcrud.entity.Person;


public interface PersonService {
	public List<Person> findAll();
	public Person findById(int theId);
	public void save(Person thePerson);
	public void deleteById(int theId);
}
