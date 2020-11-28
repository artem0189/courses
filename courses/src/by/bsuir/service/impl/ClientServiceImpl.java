package by.bsuir.service.impl;

import by.bsuir.entity.User;
import by.bsuir.entity.UserData;
import by.bsuir.service.ClientService;
import by.bsuir.service.validation.AuthorizationValidator;
import by.bsuir.service.validation.RegistrationValidator;
import by.bsuir.service.validation.ValidatorException;
import by.bsuir.dao.DAOProvider;
import by.bsuir.dao.UserDAO;
import by.bsuir.dao.DAOException;
import by.bsuir.service.ServiceException;

public class ClientServiceImpl implements ClientService {
	private final UserDAO userDAO = DAOProvider.getInstance().getUserDAO(); 
	
	@Override
	public User authorization(String username, String password) throws ServiceException {
		User user = null;
		
		try {
			AuthorizationValidator.checkValidation(username, password);
			user = userDAO.authentification(username, password);
		} catch (ValidatorException e) { 
			throw new ServiceException("invalid username or password");
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
		return user;
	}
	
	@Override
	public boolean registration(UserData userData) throws ServiceException {
		boolean isRegister = false;
		
		try {
			RegistrationValidator.checkValidation(userData);
			isRegister = userDAO.registration(userData);
		} catch (ValidatorException e) {
			throw new ServiceException(e.getMessage());
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
		
		return isRegister;
	}
}
