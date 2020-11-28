package by.bsuir.service.validation;

public class AuthorizationValidator {
	public static void checkValidation(String username, String password) throws ValidatorException {
		checkUsername(username);
		checkPassword(password);
	}
	
	private static void checkUsername(String username) throws ValidatorException {
		boolean isRequiredLength = username.length() > 6;
		boolean isMatchesThePattern = username.matches("[A-Za-z0-9_]+");
		
		if (!isRequiredLength || !isMatchesThePattern) {
			throw new ValidatorException();
		}
	}
	
	private static void checkPassword(String password) throws ValidatorException {
		boolean isRequiredLength = password.length() > 6;
		boolean isMatchesThePattern = password.matches("[A-Za-z0-9]+");
		
		if (!isRequiredLength || !isMatchesThePattern) {
			throw new ValidatorException();
		}
	}
}
