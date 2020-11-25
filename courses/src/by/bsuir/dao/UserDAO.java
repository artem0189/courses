package by.bsuir.dao;

import by.bsuir.entity.User;

public interface UserDAO {
	User authentification(String login, String password) throws DAOException;
}
