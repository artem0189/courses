package by.bsuir.dao;

import by.bsuir.dao.impl.SQLUserDAO;
import by.bsuir.dao.impl.SQLCourseDAO;

public class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();
	
	private final UserDAO userDAO = new SQLUserDAO();
	private final CourseDAO courseDAO = new SQLCourseDAO();
	
	private DAOProvider() {}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}
	
	public static DAOProvider getInstance() {
		return instance;
	}
}
