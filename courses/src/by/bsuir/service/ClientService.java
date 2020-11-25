package by.bsuir.service;

import by.bsuir.entity.User;
import by.bsuir.entity.UserData;

public interface ClientService {
	User authorization(String login, String password) throws ServiceException;
	
	boolean registration(UserData userData) throws ServiceException;
}
