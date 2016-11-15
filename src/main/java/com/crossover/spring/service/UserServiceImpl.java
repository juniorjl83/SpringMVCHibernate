package com.crossover.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.crossover.spring.dao.GenericDao;
import com.crossover.spring.dao.UserDao;
import com.crossover.spring.model.User;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService{

	private UserDao userDao;
	
	public UserServiceImpl(){}
	
	@Autowired
	public UserServiceImpl(
			@Qualifier("userDaoImpl") GenericDao<User, Integer> genericDao){
		super(genericDao);
		this.userDao = (UserDao) genericDao;
	}

	@Override
	public boolean isValidUser(String username, String password) {
		return userDao.isValidUser(username, password);
	}
	

}
