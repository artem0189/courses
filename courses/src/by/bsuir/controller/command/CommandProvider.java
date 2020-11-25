package by.bsuir.controller.command;

import java.util.Map;
import java.util.HashMap;

import by.bsuir.controller.command.impl.GoToMainPageCommand;
import by.bsuir.controller.command.impl.GoToLogInPageCommand;
import by.bsuir.controller.command.impl.GoToRegistrationPageCommand;
import by.bsuir.controller.command.impl.LogInCommand;
import by.bsuir.controller.command.impl.LogOutCommand;

public class CommandProvider {
	public Map<String, Command> commands = new HashMap<String, Command>();
	
	public CommandProvider() {
		commands.put(CommandName.GO_TO_MAIN_COMMAND, new GoToMainPageCommand());
		commands.put(CommandName.GO_TO_LOGIN_COMMAND, new GoToLogInPageCommand());
		commands.put(CommandName.GO_TO_REGISTRATION_COMMAND, new GoToRegistrationPageCommand());
		commands.put(CommandName.LOGIN_COMMAND, new LogInCommand());
		commands.put(CommandName.LOGOUT_COMMAND, new LogOutCommand());
	}
	
	public Command getCommand(String commandName) {
		return commands.get(commandName);
	}
}
