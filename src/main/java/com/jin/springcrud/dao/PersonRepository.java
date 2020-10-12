package com.jin.springcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jin.springcrud.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	// this jpa repository is acually not used in my project. I used hibernate otherwise.
}
