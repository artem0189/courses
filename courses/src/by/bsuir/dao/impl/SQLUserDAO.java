package by.bsuir.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import by.bsuir.dao.UserDAO;
import by.bsuir.dao.DAOException;
import by.bsuir.dao.DAOManager;
import by.bsuir.entity.User;

public class SQLUserDAO implements UserDAO{
	private static Connection connection = DAOManager.getConnection();
	
	private static final String AUTHENTIFICATION_QUERY =
			"SELECT * FROM users WHERE username = ? AND password = ?";
	
	@Override
	public User authentification(String login, String password) throws DAOException {
		User user = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			preparedStatement = connection.prepareStatement(AUTHENTIFICATION_QUERY);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeQuery();
			if (result.next()) {
				user = new User();
				user.setId(result.getInt("id"));
				user.setUsername(result.getString("username"));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return user;
	}
}
