package com.datasheet.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.datasheet.model.User;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		
		user.setUserId(rs.getString("userId"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		return user;
	}
}
