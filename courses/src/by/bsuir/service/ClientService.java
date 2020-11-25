package by.bsuir.service;

import by.bsuir.entity.User;

public interface ClientService {
	User authorization(String login, String password) throws ServiceException;
}
