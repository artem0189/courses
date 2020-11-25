package by.bsuir.service.impl;

import by.bsuir.entity.User;
import by.bsuir.service.ClientService;
import by.bsuir.service.validation.AuthorizationValidator;
import by.bsuir.dao.DAOProvider;
import by.bsuir.dao.UserDAO;
import by.bsuir.dao.DAOException;
import by.bsuir.service.ServiceException;

public class ClientServiceImpl implements ClientService {
	@Override
	public User authorization(String login, String password) throws ServiceException {
		if (!AuthorizationValidator.isCorrect(login, password)) {
			// error
		}
		
		DAOProvider daoProvider = DAOProvider.getInstance();
		UserDAO userDAO = daoProvider.getUserDAO();
		
		User user = null;
		
		try {
			user = userDAO.authentification(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return user;
	}
}
