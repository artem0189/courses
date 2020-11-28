package by.bsuir.dao.impl;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import by.bsuir.entity.Course;
import by.bsuir.dao.DAOProvider;
import by.bsuir.dao.CourseDAO;
import by.bsuir.dao.DAOException;
import by.bsuir.dao.DAOManager;

public class SQLCourseDAO implements CourseDAO{
	private static Connection connection = DAOManager.getConnection();
	
	private static final String GET_ALL_QUERY = 
			"SELECT * FROM courses";
	
	@Override
	public ArrayList<Course> getAll() throws DAOException {
		ArrayList<Course> courses = new ArrayList<Course>();
		ResultSet result = null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_QUERY);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				courses.add(new Course(
						result.getInt("id"),
						result.getString("title"),
						result.getString("description"),
						DAOProvider.getInstance().getUserDAO().getById(result.getInt("id"))));
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		
		return courses;
	}
}
