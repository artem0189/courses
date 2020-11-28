package by.bsuir.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.controller.command.Command;
import by.bsuir.entity.Course;
import by.bsuir.service.CourseService;
import by.bsuir.service.ServiceException;
import by.bsuir.service.ServiceProvider;

public class GetCoursesCommand implements Command {
	private static final GetCoursesCommand instance = new GetCoursesCommand();
	
	private GetCoursesCommand() {}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		CourseService courseService = serviceProvider.getCourseService();
		
		try {
			ArrayList<Course> courses = courseService.getAll();
			request.setAttribute("courses", courses);
		} catch (ServiceException e) {
			//
		}
	}
	
	public static GetCoursesCommand getInstance() {
		return instance;
	}
}
