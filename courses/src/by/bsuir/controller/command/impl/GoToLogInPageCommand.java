package by.bsuir.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.controller.JspPageName;
import by.bsuir.controller.command.Command;

public class GoToLogInPageCommand implements Command {
	private static final String PARAMETER_COMMAND = "command";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/controller?" + PARAMETER_COMMAND + "=" + );
		//RequestDispatcher dispatcher = request.getRequestDispatcher(JspPageName.LOGIN_PAGE);
		//dispatcher.forward(request, response);
	}
}
