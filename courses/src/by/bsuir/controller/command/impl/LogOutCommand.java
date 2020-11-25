package by.bsuir.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.controller.command.Command;
import by.bsuir.controller.command.CommandName;

public class LogOutCommand extends Command {
	public LogOutCommand() {
		super(true, false);
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String commandName = CommandName.GO_TO_INDEX_COMMAND;
		if (session != null && session.getAttribute("user") != null) {
			session.invalidate();
			commandName = CommandName.GO_TO_MAIN_COMMAND;
		}
		
		response.sendRedirect(request.getRequestURL() + "?command=" + commandName);
	}
}
