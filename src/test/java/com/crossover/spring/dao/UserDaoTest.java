package com.crossover.spring.dao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.crossover.spring.model.User;
import com.crossover.spring.service.UserService;
import com.crossover.spring.service.UserServiceImpl;

public class UserDaoTest {

	private UserDao mockUserDao;
	private UserService testSubject;
	
	@Before
	public void setUp() throws Exception {
		mockUserDao = mock(UserDao.class);
		testSubject = new UserServiceImpl(mockUserDao);
	}

	User u1 = new User("admin", "admin456", new Date());
	User u2 = new User("user01", "user01", new Date());
	User[] users = {u1, u2};
	
	@Test
	public void testCallGetAll() {

		when(mockUserDao.getAll()).thenReturn(Arrays.asList(users));
		int n = testSubject.getAll().size();
		
		verify(mockUserDao, times(1)).getAll();
		
		assertTrue(n > 0);
		
	}
	
	@Test
	public void testControllerCallById(){
		
		when(mockUserDao.find(1)).thenReturn(new User("1", "user01", "user 01", "user01@gmail.com", 
				true, new Date(), null));
		User u = testSubject.get(1);
		assertThat(u.getName(), equalTo("user 01"));
		
	}

}
