package by.bsuir.service.impl;

import by.bsuir.entity.User;
import by.bsuir.entity.UserData;
import by.bsuir.service.ClientService;
import by.bsuir.service.validation.AuthorizationValidator;
import by.bsuir.service.validation.RegistrationValidator;
import by.bsuir.dao.DAOProvider;
import by.bsuir.dao.UserDAO;
import by.bsuir.dao.DAOException;
import by.bsuir.service.ServiceException;

public class ClientServiceImpl implements ClientService {
	private final UserDAO userDAO = DAOProvider.getInstance().getUserDAO(); 
	
	@Override
	public User authorization(String login, String password) throws ServiceException {
		if (!AuthorizationValidator.isCorrect(login, password)) {
			// error
		}

		User user = null;
		
		try {
			user = userDAO.authentification(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return user;
	}
	
	@Override
	public boolean registration(UserData userData) throws ServiceException {
		// Validator
		
		boolean isRegister = false;
		
		try {
			isRegister = userDAO.registration(userData);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return isRegister;
	}
}
