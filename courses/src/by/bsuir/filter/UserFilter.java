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

@WebFilter({ ControllerName.CATALOG_CONTROLLER_NAME })
public class UserFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		HttpSession session = request.getSession();
		
		if (session != null && session.getAttribute("user") != null) {
			chain.doFilter(servletRequest, servletResponse);
		} else {
			response.sendRedirect(request.getContextPath() + ControllerName.LOGIN_CONTROLLER_NAME);
		}
	}
}
