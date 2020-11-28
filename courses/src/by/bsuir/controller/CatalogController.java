package by.bsuir.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.controller.command.CommandName;

@WebServlet(ControllerName.CATALOG_CONTROLLER_NAME)
public class CatalogController extends Controller {
	private static final long serialVersionUID = 1L;
	
	private static final String CONTROLLER_NAME = ControllerName.CATALOG_CONTROLLER_NAME;
	private static final String PAGE_NAME = JspPageName.CATALOG_PAGE;
	
	public CatalogController() {
		super(CONTROLLER_NAME, PAGE_NAME);
	}
	
	@Override
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commandName = request.getParameter(PARAMETER_COMMAND);
		if (commandName != null) {
			provider.getCommand(CONTROLLER_NAME, commandName).execute(request, response);
		} else {
			provider.getCommand(CONTROLLER_NAME, CommandName.GET_COURSES_COMMAND).execute(request, response);
			request.getRequestDispatcher(JspPageName.CATALOG_PAGE).forward(request, response);
			//response.sendRedirect(request.getContextPath() + ControllerName.CATALOG_CONTROLLER_NAME);
		}
	}
}
