package com.jin.springcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jin.springcrud.entity.Person;

@Repository

public class HibernatePersonDAO implements PersonDAO {
	// define fields for entitymanager
	
	private EntityManager entityManager;
	// set up constructor injection
	@Autowired
	public HibernatePersonDAO(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	@Override
	@Transactional
	public List<Person> findAll() {

		// get a hibernate session
		Session currentSession= entityManager.unwrap(Session.class);
		// create a query
		Query<Person> theQuery= currentSession.createQuery("from Person", Person.class);
		// execute query and have the result
		List<Person> result = theQuery.getResultList();
		// return the results
		
		return result;
	}

	@Override
	public Person findById(int theId) {
		Session currentSession= entityManager.unwrap(Session.class);
		Person thePerson= currentSession.get(Person.class, theId);
		return thePerson;
	}

	@Override
	public void save(Person thePerson) {
		Session currentSession= entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(thePerson);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Session currentSession= entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Person where id=:theId");
		theQuery.setParameter("theId", theId);
		theQuery.executeUpdate();
	}

}
