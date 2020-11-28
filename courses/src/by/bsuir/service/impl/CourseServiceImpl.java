package by.bsuir.service.impl;

import java.util.ArrayList;

import by.bsuir.dao.DAOProvider;
import by.bsuir.dao.CourseDAO;
import by.bsuir.dao.DAOException;
import by.bsuir.entity.Course;
import by.bsuir.service.CourseService;
import by.bsuir.service.ServiceException;

public class CourseServiceImpl implements CourseService {
	private final CourseDAO courseDAO = DAOProvider.getInstance().getCourseDAO(); 
	
	@Override
	public ArrayList<Course> getAll() throws ServiceException {
		ArrayList<Course> courses = null;
		
		try {
			courses = courseDAO.getAll();
		} catch(DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
		return courses;
	}
}
