package by.bsuir.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.controller.JspPageName;
import by.bsuir.controller.command.Command;

public class GoToRegistrationPageCommand extends Command {
	public GoToRegistrationPageCommand() {
		super(false, true);
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(JspPageName.REGISTRATION_PAGE);
		dispatcher.forward(request, response);
	}
}
