package com.datasheet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasheet.data.UserDAO;
import com.datasheet.model.User;

@Service("userFacade")
public class UserServiceFacade implements UserService {

	@Autowired
	UserDAO userDAO;
	
	public void addUser(User user) {
		userDAO.addUser(user);
		
	}

	public User getUserByName(String name) {
		return userDAO.getUserByName(name);
	}

	public void deleteUser(User user) {
		userDAO.deleteUser(user);
	}

}
