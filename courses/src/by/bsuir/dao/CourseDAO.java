package by.bsuir.dao;

import java.util.ArrayList;

import by.bsuir.entity.Course;

public interface CourseDAO {
	ArrayList<Course> getAll() throws DAOException;
}
