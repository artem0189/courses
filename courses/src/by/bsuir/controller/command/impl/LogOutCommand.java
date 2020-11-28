package by.bsuir.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.bsuir.controller.command.Command;
import by.bsuir.controller.ControllerName;

public class LogoutCommand implements Command {
	private static final LogoutCommand instance = new LogoutCommand();
	
	private LogoutCommand() {};
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session != null && session.getAttribute("user") != null) {
			session.invalidate();
		}
		
		response.sendRedirect(request.getContextPath() + ControllerName.MAIN_CONTROLLER_NAME);
	}
	
	public static LogoutCommand getInstance() {
		return instance;
	}
}
