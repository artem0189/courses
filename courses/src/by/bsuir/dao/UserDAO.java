package by.bsuir.dao;

import by.bsuir.entity.User;
import by.bsuir.entity.UserData;

public interface UserDAO {
	User authentification(String username, String password) throws DAOException;
	
	boolean registration(UserData userData) throws DAOException;
	
	User getById(int id) throws DAOException;
}
