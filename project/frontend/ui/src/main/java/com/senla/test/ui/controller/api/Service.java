package com.senla.test.ui.controller.api;

import com.senla.test.protocol.context.CommandContext;

public interface Service {
	
	void executeCommand(CommandContext context);
	
	void shutdown();

}
