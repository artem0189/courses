package by.bsuir.controller.command;

import java.util.Map;
import java.util.HashMap;

import by.bsuir.controller.command.impl.GoToMainPageCommand;

public class CommandProvider {
	private Map<String, Command> commands = new HashMap<String, Command>();
	
	public CommandProvider() {
		commands.put("go_to_main", new GoToMainPageCommand());
	}
	
	public Command getCommand(String commandName) {
		return commands.get(commandName);
	}
}
