package com.senla.test.protocol.context;

import java.util.HashMap;
import java.util.Map;

public class CommandContext {
	
	private String commandName;
	
	private Map<String, String> context;
	
	public CommandContext(){
		this.context = new HashMap<String, String>();
	}

	public Map<String, String> getContext() {
		return context;
	}

	public void setContext(Map<String, String> context) {
		this.context = context;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

}
