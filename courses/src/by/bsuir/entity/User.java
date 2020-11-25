package by.bsuir.entity;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 5438L;
	
	private int id;
	private String username;
	
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
}
