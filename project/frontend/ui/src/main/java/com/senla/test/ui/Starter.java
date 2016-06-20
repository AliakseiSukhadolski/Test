package com.senla.test.ui;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.senla.test.client.module.ClientModule;
import com.senla.test.ui.controller.api.Controller;
import com.senla.test.ui.module.FrontendModule;

public class Starter {
	
	//point of access of client application
	
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new FrontendModule(), new ClientModule());
		injector.getInstance(Controller.class).start();
	}

}
