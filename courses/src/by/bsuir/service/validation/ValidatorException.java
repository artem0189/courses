package by.bsuir.service.validation;

public class ValidatorException extends Exception {
	private static final long serialVersionUID = 6454732L;
	
	public ValidatorException() {
		super();
	}
	
	public ValidatorException(String message) {
		super(message);
	}
	
	public ValidatorException(Exception e) {
		super(e);
	}
	
	public ValidatorException(String message, Exception e) {
		super(message, e);
	}
}
