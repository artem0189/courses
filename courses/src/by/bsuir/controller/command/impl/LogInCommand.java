package by.bsuir.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.controller.JspPageName;
import by.bsuir.controller.command.CommandName;
import by.bsuir.controller.command.Command;
import by.bsuir.service.ServiceProvider;
import by.bsuir.service.ClientService;
import by.bsuir.entity.User;
import by.bsuir.service.ServiceException;

public class LogInCommand extends Command {
	private static final String PARAMETER_LOGIN = "login";
	private static final String PARAMETER_PASSWORD = "password";
	
	public LogInCommand() {
		super(false, true);
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(PARAMETER_LOGIN);
		String password = request.getParameter(PARAMETER_PASSWORD);
		
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ClientService clientService = serviceProvider.getClientService();
		
		User user = null;
		try {
			user = clientService.authorization(login, password);
			if (user == null) {
				request.setAttribute("error", "trehjy");
				request.getRequestDispatcher(JspPageName.LOGIN_PAGE).forward(request, response);
			} else {
				request.getSession().setAttribute("user", user);
				response.sendRedirect(request.getRequestURL() + "?command=" + CommandName.GO_TO_MAIN_COMMAND);
			}
		} catch (ServiceException e) {
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher(JspPageName.LOGIN_PAGE).forward(request, response);
		}
	}
}
