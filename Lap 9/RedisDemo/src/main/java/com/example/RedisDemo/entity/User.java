package com.example.RedisDemo.entity;

import java.io.Serializable;
import java.util.Date;

  
public class User implements Serializable {
	private String id;
	private String name;
	private String email;
	
	public User(String name, String email) {
		super();
		this.id = String.valueOf(new Date().getTime());
		this.name = name;
		this.email = email;
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
	

}
