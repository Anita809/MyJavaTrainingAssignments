package com.java.service;

import java.util.List;

import com.java.dao.UserDAO;
import com.java.model.User;

public class UserService {
	UserDAO userDao = new UserDAO();

	public List<User> getAllUsers() {
		List<User> userList = userDao.getAllUsers();
		return userList;
	}

	public User getUserForId(String id) {
		//u can write business logic code
		//some business logic can be written here
		User user = userDao.getUserForId(id);
		//post activity after dao.
		return user;
	} 

	public User createUser(User user) {
		User userResponse = userDao.createUser(user);
		return userResponse;
	}

	public User updateUser(User user) {
		User userResponse = userDao.updateUser(user);
		return userResponse;
	}

	public User deleteUser(String id) {
		User userResponse = userDao.deleteUser(id);
		return userResponse;
	}

}
