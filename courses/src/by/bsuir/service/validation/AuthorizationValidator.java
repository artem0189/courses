package by.bsuir.service.validation;

public class AuthorizationValidator {
	public static boolean isCorrect(String login, String password) {
		return isLoginCorrect(login) && isPasswordCorrect(password);
	}
	
	private static boolean isLoginCorrect(String login) {
		//
		return true;
	}
	
	private static boolean isPasswordCorrect(String password) {
		//
		return true;
	}
}
