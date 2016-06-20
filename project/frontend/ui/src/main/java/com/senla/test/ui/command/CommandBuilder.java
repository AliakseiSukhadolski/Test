package com.senla.test.ui.command;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;
import com.senla.test.ui.command.impl.ExitCommand;
import com.senla.test.ui.command.impl.ExpandCommand;
import com.senla.test.ui.controller.api.Service;

public class CommandBuilder {
	
	@Inject
	private Service service;
	
	public Map<String, Command> getCommands(){
		Map<String, Command> commands = new HashMap<String, Command>();
		Command command = new ExpandCommand();
		command.setService(service);
		commands.put(command.getName(), command);
		command = new ExitCommand();
		command.setService(service);
		commands.put(command.getName(), command);
		
		return commands;
	}

}
