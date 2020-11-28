package by.bsuir.entity;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 5438L;
	
	private int id;
	private String username;
	private String name;
	private String surname;
	private int roleId;
	
	public User() {}
	
	public User(int id, String username, String name, String surname, int roleId) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.roleId = roleId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
