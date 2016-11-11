package com.crossover.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.crossover.spring.dao.GenericDao;
import com.crossover.spring.dao.PersonDao;
import com.crossover.spring.model.Person;

@Service
public class PersonServiceImpl extends GenericServiceImpl<Person, Integer> implements PersonService {

	private PersonDao personDao;

	public PersonServiceImpl(){
		 
    }
	
    @Autowired
    public PersonServiceImpl(
            @Qualifier("personDaoImpl") GenericDao<Person, Integer> genericDao) {
        super(genericDao);
        this.personDao = (PersonDao) genericDao;
    }


}
