package com.senla.test.server;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.senla.test.core.module.CoreModule;
import com.senla.test.server.module.ServerModule;

public class Starter {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new ServerModule(), new CoreModule());
		injector.getInstance(Server.class).start();

	}

}
