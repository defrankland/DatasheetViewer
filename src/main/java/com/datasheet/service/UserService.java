package com.datasheet.service;

import com.datasheet.model.User;

public interface UserService {

	public void addUser(User user);
	public User getUserByName(String name);
	public void deleteUser(User user);
}
