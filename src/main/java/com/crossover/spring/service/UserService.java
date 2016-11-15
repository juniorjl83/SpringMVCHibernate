package com.crossover.spring.service;

import com.crossover.spring.model.User;

public interface UserService extends GenericService<User, Integer> {

	public boolean isValidUser (String username, String password);
}
