package by.bsuir.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.bsuir.controller.command.CommandName;

public class UserFilter implements Filter {
	private static final String PARAMETER_COMMAND = "command";
	
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			chain.doFilter(servletRequest, servletResponse);
		} else {
			String commandName = request.getParameter(PARAMETER_COMMAND);
			if (commandName.equals(CommandName.GO_TO_LOGIN_COMMAND) || commandName.equals(CommandName.GO_TO_REGISTRATION_COMMAND)) {
				chain.doFilter(servletRequest, servletResponse);
			} else {
				response.sendRedirect(request.getContextPath() + "/controller?" + PARAMETER_COMMAND + "=" + CommandName.GO_TO_LOGIN_COMMAND);	
			}
		}
	}
}
