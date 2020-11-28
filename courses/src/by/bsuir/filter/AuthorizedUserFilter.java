package by.bsuir.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.bsuir.controller.ControllerName;

@WebFilter({ ControllerName.LOGIN_CONTROLLER_NAME, ControllerName.REGISTRATION_CONTROLLER_NAME })
public class AuthorizedUserFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession();
		
		if (session != null && session.getAttribute("user") != null) {
			response.sendRedirect(request.getContextPath() + ControllerName.MAIN_CONTROLLER_NAME);
		} else {
			chain.doFilter(servletRequest, servletResponse);
		}
	}
}
