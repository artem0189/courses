package by.bsuir.service;

import java.util.ArrayList;

import by.bsuir.entity.Course;

public interface CourseService {
	ArrayList<Course> getAll() throws ServiceException;
}
