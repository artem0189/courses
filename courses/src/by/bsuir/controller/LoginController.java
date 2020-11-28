package by.bsuir.controller;

import javax.servlet.annotation.WebServlet;

@WebServlet(ControllerName.LOGIN_CONTROLLER_NAME)
public class LoginController extends Controller {
	private static final long serialVersionUID = 1L;
	
	private static final String CONTROLLER_NAME = ControllerName.LOGIN_CONTROLLER_NAME;
	private static final String PAGE_NAME = JspPageName.LOGIN_PAGE;
	
	public LoginController() {
		super(CONTROLLER_NAME, PAGE_NAME);
	}
}
