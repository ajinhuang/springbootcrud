package com.jin.springcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jin.springcrud.dao.PersonDAO;
import com.jin.springcrud.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {
	public PersonDAO personDAO;
	@Autowired
	public PersonServiceImpl(PersonDAO peronDAO) {
		super();
		this.personDAO = peronDAO;
	}

	@Override
	@Transactional
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return personDAO.findAll();
	}

	@Override
	@Transactional
	public Person findById(int theId) {
		// TODO Auto-generated method stub
		return  personDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Person thePerson) {
		// TODO Auto-generated method stub
		personDAO.save(thePerson);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		personDAO.deleteById(theId);

	}

}
