package by.bsuir.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.bsuir.controller.command.Command;
import by.bsuir.controller.command.CommandProvider;
import by.bsuir.controller.command.CommandName;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String PARAMETER_COMMAND = "command";
	private final CommandProvider provider = new CommandProvider();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commandName = request.getParameter(PARAMETER_COMMAND);
		Command command = provider.getCommand(commandName);	
		doFilterTe(request, response, command);
	}
	
	private void doFilterTe(HttpServletRequest request, HttpServletResponse response, Command command) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (command != null) {
			if (session != null && session.getAttribute("user") != null) {
				if (!command.canExecuteIfLogIn) {
					response.sendRedirect(request.getRequestURL() + "?" + PARAMETER_COMMAND + "=" + CommandName.GO_TO_MAIN_COMMAND);
					return;
				}
			} else {
				if (!command.canExecuteIfNotLogIn) {
					response.sendRedirect(request.getRequestURL() + "?" + PARAMETER_COMMAND + "=" + CommandName.GO_TO_LOGIN_COMMAND);
					return;
				}
			}	
			command.execute(request, response);
		} else {
			//response.sendRedirect(request.getRequestURL() + "?" + PARAMETER_COMMAND + "=" + CommandName.GO_TO_ERROR_COMMAND); 404
		}
	}
}
