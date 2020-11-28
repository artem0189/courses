package by.bsuir.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import by.bsuir.dao.UserDAO;
import by.bsuir.dao.DAOException;
import by.bsuir.dao.DAOManager;
import by.bsuir.dao.util.SHA256Hasher;
import by.bsuir.entity.User;
import by.bsuir.entity.UserData;

public class SQLUserDAO implements UserDAO{
	private static Connection connection = DAOManager.getConnection();
	
	private static final String AUTHENTIFICATION_QUERY =
			"SELECT * FROM users WHERE username = ? AND password = ?";
	private static final String REGISTRATION_QUERY = 
			"INSERT INTO users(username, password, name, surname) VALUES(?, ?, ?, ?)";
	private static final String GET_USER_BY_ID_QUERY = 
			"SELECT * FROM users WHERE id = ?";
	
	@Override
	public User authentification(String username, String password) throws DAOException {
		User user = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = connection.prepareStatement(AUTHENTIFICATION_QUERY);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, SHA256Hasher.hash(password));
			result = preparedStatement.executeQuery();
			if (result.next()) {
				user = new User(
						result.getInt("id"),
						result.getString("username"),
						result.getString("name"),
						result.getString("surname"),
						result.getInt("roleId"));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return user;
	}
	
	@Override
	public boolean registration(UserData userData) throws DAOException {
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		try {
			preparedStatement = connection.prepareStatement(REGISTRATION_QUERY);
			preparedStatement.setString(1, userData.getUsername());
			preparedStatement.setString(2, SHA256Hasher.hash(userData.getPassword()));
			preparedStatement.setString(3, userData.getName());
			preparedStatement.setString(4, userData.getSurname());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return result != 0;
	}
	
	@Override
	public User getById(int id) throws DAOException {
		User user = null;
		ResultSet result = null;
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement(GET_USER_BY_ID_QUERY);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			if (result.next()) {
				user = new User(
						result.getInt("id"),
						result.getString("username"),
						result.getString("name"),
						result.getString("surname"),
						result.getInt("roleId"));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return user;
	}
}
