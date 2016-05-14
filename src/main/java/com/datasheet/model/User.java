/**
 * 
 */
package com.datasheet.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;


public class User {
	@Id
	private String userId;
	
	@DBRef
	private String password;
	private String name;
	private String email;
	private boolean enabled;
	private String role;
	
	public User(){
		this.userId = java.util.UUID.randomUUID().toString();
	}
	
	public User(String name, String password, String email){
		this.userId = java.util.UUID.randomUUID().toString();
		this.name = name;
		this.password = password;
		this.email = email;
		this.enabled = true;
		this.role = "ROLE_USER";
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public boolean getEnable(){
		return enabled;
	}
	
	public String getRole(){
		return role;
	}
	
}
