package com.crossover.spring.dao;

import com.crossover.spring.model.User;

public interface UserDao extends GenericDao<User, Integer> {

	public boolean isValidUser (String username, String password);
}
