package com.senla.test.ui.command.impl;

import java.util.Map;

import com.senla.test.ui.command.Command;
import com.senla.test.ui.command.common.StatusType;

public class ExitCommand extends Command{

	public ExitCommand() {
		super("exit");
	}

	@Override
	protected Map<String, String> parseCommand(String command) {
		return null;
	}

	@Override
	public StatusType execute(String command) {
		service.shutdown();
		return StatusType.EXIT;
	}

}
