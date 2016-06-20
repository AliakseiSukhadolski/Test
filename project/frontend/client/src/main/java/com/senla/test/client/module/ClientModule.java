package com.senla.test.client.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.senla.test.client.Client;

public class ClientModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(Client.class).in(Singleton.class);
	}
	

}
