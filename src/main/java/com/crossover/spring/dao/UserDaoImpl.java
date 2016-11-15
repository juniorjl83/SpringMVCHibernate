package com.crossover.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.spring.model.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean isValidUser(String username, String password) {

		Query query = currentSession().createQuery("from User where userId = :username and password = :password ");
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		List list = query.list();
		
		if ( list.isEmpty() ){
			return false;
		}
		
		return true;
	}

	

}
