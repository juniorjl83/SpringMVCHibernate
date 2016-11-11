package com.crossover.spring.dao;

import org.springframework.stereotype.Repository;

import com.crossover.spring.model.Person;

@Repository
public class PersonDaoImpl extends GenericDaoImpl<Person, Integer> implements PersonDao {


}