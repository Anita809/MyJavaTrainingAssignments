package com.java.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.java.model.User;

//Just to avoid DB calls in this example, Assume below data is interacting with DB
public class UserDAO {
	static HashMap<String, User> usersMap = new HashMap<String, User>();

	public UserDAO() {
			User user1 = new User();
			user1.setId("1"); //this is not the key - just a simple variable - may be a primary key 
			user1.setAge(20);
			user1.setName("raj");
			
			User user2 = new User();
			user2.setId("2");
			user2.setAge(21);
			user2.setName("ram");
			
			usersMap.put("1", user1); //"1"is the KEY /emailid as a  key too
			usersMap.put("2", user2);
	}

	public List<User> getAllUsers() {

		List<User> userList = new ArrayList<User>(usersMap.values());
		return userList;
	}

	public User getUserForId(String id) {
		User user = usersMap.get(id); //map's get method
		return user;
	}

	public User createUser(User user) {
		usersMap.put(user.getId(), user); //add to the map
		return usersMap.get(user.getId());//confirm from the map
	}

	public User updateUser(User user) {
		User existingUser= usersMap.get(user.getId());
		if (existingUser != null) { //update 
			existingUser.setName(user.getName());
			existingUser.setAge(user.getAge());
		} else {
			usersMap.put(user.getId(), user); // save
		}
		return usersMap.get(user.getId()); //confirm the map updates
	}

	public User deleteUser(String id) {
		User userResponse = usersMap.remove(id);
		return userResponse;
	}

}
