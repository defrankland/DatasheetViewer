package com.datasheet.data;

import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.datasheet.model.User;

@Repository("userDAO")
public class UserRepository implements UserDAO {

	@Autowired
	private DataSource userDb;

	@Resource
	private Map<String,String> userDbSqlQuery;
	
	public void addUser(User user) {
		
		try{
			JdbcTemplate template = new JdbcTemplate(userDb);
			
			template.update(userDbSqlQuery.get("insert"),
							new Object[] { user.getUserId(),
										   user.getEmail(),
										   user.getName(), 
										   user.getPassword(),
										   user.getEnable()});
			
			template.update(userDbSqlQuery.get("insertRole"),
			                new Object[] {user.getName(),
				                          user.getRole()});
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	public User getUserByName(String name) {
		User user = null;
		JdbcTemplate template = new JdbcTemplate(userDb);
		
		try {
			user = template.queryForObject(userDbSqlQuery.get("find"),
					new Object[] { name },
					new UserRowMapper());
			
		} catch (EmptyResultDataAccessException ex) {}
		return user;
	}

	public void deleteUser(User user) {
		
		try{
			JdbcTemplate template = new JdbcTemplate(userDb);
			template.update(userDbSqlQuery.get("delete"), new Object[] { user.getUserId()});
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		
	}

}
