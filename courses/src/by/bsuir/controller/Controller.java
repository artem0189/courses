package by.bsuir.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.controller.command.CommandProvider;

public abstract class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected static final String PARAMETER_COMMAND = "command";
	protected static final CommandProvider provider = CommandProvider.getInstance();
	
	private String controllerName;
	private String pageName;
	
	public Controller(String controllerName, String pageName) {
		this.controllerName = controllerName;
		this.pageName = pageName;
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commandName = request.getParameter(PARAMETER_COMMAND);
		if (commandName != null) {
			provider.getCommand(controllerName, commandName).execute(request, response);
		} else {
			request.getRequestDispatcher(pageName).forward(request, response);
		}
	}
}
