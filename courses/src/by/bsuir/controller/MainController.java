package by.bsuir.controller;

import javax.servlet.annotation.WebServlet;

@WebServlet(ControllerName.MAIN_CONTROLLER_NAME)
public class MainController extends Controller {
	private static final long serialVersionUID = 1L;
	
	private static final String CONTROLLER_NAME = ControllerName.MAIN_CONTROLLER_NAME;
	private static final String PAGE_NAME = JspPageName.MAIN_PAGE;
	
	public MainController() {
		super(CONTROLLER_NAME, PAGE_NAME);
	}
}
