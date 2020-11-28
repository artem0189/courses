package by.bsuir.controller.command;

import java.util.Map;
import java.util.HashMap;

import by.bsuir.controller.ControllerName;
import by.bsuir.controller.command.impl.LoginCommand;
import by.bsuir.controller.command.impl.LogoutCommand;
import by.bsuir.controller.command.impl.RegistrationCommand;
import by.bsuir.controller.command.impl.GetCoursesCommand;

public class CommandProvider {
	private static final CommandProvider instance = new CommandProvider();
	
	private final Map<String, Map<String, Command>> commands = new HashMap<String, Map<String, Command>>();
	
	private CommandProvider() {
		commands.put(ControllerName.MAIN_CONTROLLER_NAME, new HashMap<String, Command>() {
			{
				put(CommandName.LOGOUT_COMMAND, LogoutCommand.getInstance());
			}
		});
		commands.put(ControllerName.LOGIN_CONTROLLER_NAME, new HashMap<String, Command>() {
			{
				put(CommandName.LOGIN_COMMAND, LoginCommand.getInstance());
			}
		});
		commands.put(ControllerName.REGISTRATION_CONTROLLER_NAME, new HashMap<String, Command>() {
			{
				put(CommandName.REGISTRATION_COMMAND, RegistrationCommand.getInstance());
			}
		});
		commands.put(ControllerName.CATALOG_CONTROLLER_NAME, new HashMap<String, Command>() {
			{
				put(CommandName.GET_COURSES_COMMAND, GetCoursesCommand.getInstance());
			}
		});
	}
	
	public Command getCommand(String controllerName, String commandName) {
		Map<String, Command> map = commands.get(controllerName);
		if (map != null) {
			return map.get(commandName);
		}
		return null;
	}
	
	public static CommandProvider getInstance() {
		return instance;
	}
}
