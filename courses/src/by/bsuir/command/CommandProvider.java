package by.bsuir.command;

import java.util.Map;
import java.util.HashMap;

public class CommandProvider {
	private Map<String, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		
	}
	
	public Command getCommand(String commandName) {
		return commands.get(commandName);
	}
}
