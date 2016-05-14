package com.datasheet.data;

import com.datasheet.model.User;

public interface UserDAO {
	public void addUser(User user);
	public User getUserByName(String name);
	public void deleteUser(User user);
}
