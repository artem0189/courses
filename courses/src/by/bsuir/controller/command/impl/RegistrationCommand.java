package by.bsuir.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.controller.JspPageName;
import by.bsuir.controller.ControllerName;
import by.bsuir.controller.command.Command;
import by.bsuir.entity.UserData;
import by.bsuir.service.ClientService;
import by.bsuir.service.ServiceException;
import by.bsuir.service.ServiceProvider;

public class RegistrationCommand implements Command {
	private static final RegistrationCommand instance = new RegistrationCommand();

	private static final String PARAMETER_USERNAME = "username";
	private static final String PARAMETER_PASSWORD = "password";
	private static final String PARAMETER_NAME = "name";
	private static final String PARAMETER_SURNAME = "surname";
	
	private RegistrationCommand() {};
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserData userData = new UserData();
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientService();
		
		userData.setUsername(request.getParameter(PARAMETER_USERNAME));
		userData.setPassword(request.getParameter(PARAMETER_PASSWORD));
		userData.setName(request.getParameter(PARAMETER_NAME));
		userData.setSurname(request.getParameter(PARAMETER_SURNAME));
		
		try {
			if (clientService.registration(userData)) {
				response.sendRedirect(request.getContextPath() + ControllerName.LOGIN_CONTROLLER_NAME);
			} else {
				request.setAttribute("error", "fuck");
				request.getRequestDispatcher(JspPageName.REGISTRATION_PAGE).forward(request, response);
			}
		} catch (ServiceException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher(JspPageName.REGISTRATION_PAGE).forward(request, response);
		}
	}
	
	public static RegistrationCommand getInstance() {
		return instance;
	}
}
