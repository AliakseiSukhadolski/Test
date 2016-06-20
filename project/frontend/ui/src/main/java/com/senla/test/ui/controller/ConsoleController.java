package com.senla.test.ui.controller;

import com.google.inject.Inject;
import com.senla.test.ui.command.Command;
import com.senla.test.ui.command.CommandStorage;
import com.senla.test.ui.command.common.StatusType;
import com.senla.test.ui.controller.api.Controller;
import com.senla.test.ui.util.ConsoleUtil;
import com.senla.test.ui.util.StringCommandUtil;

public class ConsoleController implements Controller{
	
	private CommandStorage storage;
	
	@Inject
	public ConsoleController(CommandStorage storage){
		this.storage = storage;
	}
	
	public void start(){
		ConsoleUtil.writeMessage("Welcome");
		ConsoleUtil.writeMessage("Exter Command : expand XXX, exit or just number(for default \"expand\" command)");
		Command command = null;
		while(true){
			String stringCommand = null;
			try{
				stringCommand = ConsoleUtil.readCommand();
			} catch (Exception e){
				ConsoleUtil.writeMessage("Problem with entering command. Please try again");
				continue;
			}
			command = storage.getCommandByKey(stringCommand);
			if(null == command){
				// Code for supporting non command integer input
				command = storage.getDefaultCommand();
				stringCommand = StringCommandUtil.convertToBasicView(stringCommand, command);
			}
			StatusType status = command.execute(stringCommand);
			if(status == StatusType.EXIT){
				break;
			}
		}
	}
}
