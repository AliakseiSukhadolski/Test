package com.senla.test.ui.command;

import java.util.Map;

import com.senla.test.ui.command.common.StatusType;
import com.senla.test.ui.controller.api.Service;

public abstract class Command {
	
	protected Service service;
	
	protected String name;
	
	public Command(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract StatusType execute(String command);
	
	protected abstract Map<String, String> parseCommand(String command);
	
	public void setService(Service service){
		this.service = service;
	}

}
