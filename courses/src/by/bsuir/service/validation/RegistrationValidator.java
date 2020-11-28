package by.bsuir.service.validation;

import by.bsuir.entity.UserData;

public class RegistrationValidator {
	public static void checkValidation(UserData userData) throws ValidatorException {
		checkUsername(userData.getUsername());
		checkPassword(userData.getPassword());
		checkName(userData.getName());
		checkSurname(userData.getSurname());
	}
	
	private static void checkUsername(String username) throws ValidatorException {
		boolean isRequiredLength = username.length() > 6;
		boolean isMatchesThePattern = username.matches("[A-Za-z0-9_]+");
		
		if (!isRequiredLength || !isMatchesThePattern) {
			throw new ValidatorException("invalid username");
		}
	}
	
	private static void checkPassword(String password) throws ValidatorException {
		boolean isRequiredLength = password.length() > 6;
		boolean isMatchesThePattern = password.matches("[A-Za-z0-9]+");
		
		if (!isRequiredLength || !isMatchesThePattern) {
			throw new ValidatorException("invalid password");
		}
	}
	
	private static void checkName(String name) throws ValidatorException {
		boolean isMatchesThePattern = name.matches("[A-Za-z]+");
		
		if (!isMatchesThePattern) {
			throw new ValidatorException("invalid name");
		}
	}
	
	private static void checkSurname(String surname) throws ValidatorException {
		boolean isMatchesThePattern = surname.matches("[A-Za-z]+");
		
		if (!isMatchesThePattern) {
			throw new ValidatorException("invalid surname");
		}
	}
}
