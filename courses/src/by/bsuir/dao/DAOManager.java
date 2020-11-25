package by.bsuir.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOManager {
	private static final DAOManager instance = new DAOManager();
	
	private static final String driverName = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/courses?serverTimezone=Europe/Minsk&useSSL=false";
	private static final String user = "root";
	private static final String password = "root";
	
	private Connection connection;
	
	private DAOManager() {
		try {
			Class.forName(driverName);	
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return instance.connection;
	}
}
