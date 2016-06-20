package com.senla.test.ui.command;

import java.util.Map;

import com.google.inject.Inject;

public class CommandStorage {
	
	private Map<String, Command> context;
	
	@Inject
	public CommandStorage(CommandBuilder builder){
		context = builder.getCommands();
	}
	
	public Command getCommandByKey(String stringCommand){
		String[] split = stringCommand.split(" ");
		Command result = null;
		result = context.get(split[0]);
		return result;
	}

	public Command getDefaultCommand(){
		return context.get("expand");
	}
}
