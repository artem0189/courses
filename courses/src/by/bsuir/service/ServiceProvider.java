package by.bsuir.service;

import by.bsuir.service.impl.ClientServiceImpl;

public class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();
	
	private ClientService clientService = new ClientServiceImpl();
	
	private ServiceProvider() {}
	
	public ClientService getClientService() {
		return clientService;
	}
	
	public static ServiceProvider getInstance() {
		return instance;
	}
}
