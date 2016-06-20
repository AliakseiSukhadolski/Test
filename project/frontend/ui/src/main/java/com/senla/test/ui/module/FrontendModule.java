package com.senla.test.ui.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.senla.test.ui.command.CommandBuilder;
import com.senla.test.ui.command.CommandStorage;
import com.senla.test.ui.controller.ConsoleController;
import com.senla.test.ui.controller.ConsoleService;
import com.senla.test.ui.controller.api.Controller;
import com.senla.test.ui.controller.api.Service;
import com.senla.test.ui.util.ExecutorStorage;

public class FrontendModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(Controller.class).to(ConsoleController.class);
		bind(Service.class).to(ConsoleService.class);
		bind(CommandStorage.class).in(Singleton.class);
		bind(ExecutorStorage.class).in(Singleton.class);
		bind(CommandBuilder.class).in(Singleton.class);
	}
	
}
