package com.jin.springcrud.dao;

import java.util.List;

import com.jin.springcrud.entity.Person;

public interface PersonDAO {
	public List<Person> findAll();
	
	public Person findById(int theId);
	
	public void save(Person thePerson);
	
	public void deleteById(int theId);
}
