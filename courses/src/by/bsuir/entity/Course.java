package by.bsuir.entity;

import java.io.Serializable;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String description;
	private User teacher;
	
	public Course() {}
	
	public Course(int id, String title, String description, User teacher) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.teacher = teacher;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getTeacher() {
		return teacher;
	}
	
	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}
}
