package by.bsuir.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.controller.JspPageName;
import by.bsuir.controller.command.Command;

public class LogOutCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session != null && session.getAttribute("user") != null) {
			session.invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher(JspPageName.MAIN_PAGE);
			dispatcher.forward(request, response);
		}
	}
}
