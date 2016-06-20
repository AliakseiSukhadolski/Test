package com.senla.test.server.module;

import com.google.inject.AbstractModule;
import com.senla.test.server.Server;

public class ServerModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(Server.class);
	}

}
