package by.bsuir.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {
	public boolean canExecuteIfLogIn;
	public boolean canExecuteIfNotLogIn;
	
	public Command(boolean canExecuteIfLogIn, boolean canExecuteIfNotLogIn) {
		this.canExecuteIfLogIn = canExecuteIfLogIn;
		this.canExecuteIfNotLogIn = canExecuteIfNotLogIn;
	}
	
	public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
