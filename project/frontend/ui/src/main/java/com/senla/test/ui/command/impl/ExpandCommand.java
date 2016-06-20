package com.senla.test.ui.command.impl;

import java.util.HashMap;
import java.util.Map;

import com.senla.test.protocol.context.CommandContext;
import com.senla.test.protocol.context.ValueType;
import com.senla.test.ui.command.Command;
import com.senla.test.ui.command.common.StatusType;
import com.senla.test.ui.exception.NotValidParamException;

public class ExpandCommand extends Command {
	
	public ExpandCommand() {
		super("expand");
	}

	@Override
	protected Map<String, String> parseCommand(String command) {
		String[] splited = command.split(" ");
		if (splited.length < 2 || !ValueType.INTEGER.checkValue(splited[1])) {
			throw new NotValidParamException("Must be integer");
		}
		Map<String, String> result = new HashMap<String, String>();
		result.put("number", splited[1]);
		return result;
	}

	@Override
	public StatusType execute(String command) {
		CommandContext context = new CommandContext();
		context.setCommandName(name);
		context.setContext(parseCommand(command));
		service.executeCommand(context);
		return StatusType.SERVER;
	}

}
