package by.bsuir.controller;

import javax.servlet.annotation.WebServlet;

@WebServlet(ControllerName.REGISTRATION_CONTROLLER_NAME)
public class RegistrationController extends Controller {
	private static final long serialVersionUID = 1L;
	
	private static final String CONTROLLER_NAME = ControllerName.REGISTRATION_CONTROLLER_NAME;
	private static final String PAGE_NAME = JspPageName.REGISTRATION_PAGE;
	
	public RegistrationController() {
		super(CONTROLLER_NAME, PAGE_NAME);
	}
}
