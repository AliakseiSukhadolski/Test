package com.senla.test.ui.controller;

import com.google.inject.Inject;
import com.senla.test.client.Client;
import com.senla.test.protocol.context.CommandContext;
import com.senla.test.ui.controller.api.Service;
import com.senla.test.ui.util.ClientThread;
import com.senla.test.ui.util.ExecutorStorage;

public class ConsoleService implements Service{
	
	private ExecutorStorage storage;
	private Client client;
	
	@Inject
	public ConsoleService(ExecutorStorage storage, Client client){
		this.storage = storage;
		this.client = client;
	}
	

	@Override
	public void executeCommand(CommandContext context) {
		storage.execute(new ClientThread(context, client.getSocket()));
	}


	@Override
	public void shutdown() {
		storage.shutdown();		
	}

}
