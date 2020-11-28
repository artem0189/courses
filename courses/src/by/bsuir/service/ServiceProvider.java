package by.bsuir.service;

import by.bsuir.service.impl.ClientServiceImpl;
import by.bsuir.service.impl.CourseServiceImpl;

public class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();
	
	private final ClientService clientService = new ClientServiceImpl();
	private final CourseService courseService = new CourseServiceImpl();
	
	private ServiceProvider() {}
	
	public ClientService getClientService() {
		return clientService;
	}
	
	public CourseService getCourseService() {
		return courseService;
	}
	
	public static ServiceProvider getInstance() {
		return instance;
	}
}
