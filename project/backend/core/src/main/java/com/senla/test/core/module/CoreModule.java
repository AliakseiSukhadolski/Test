package com.senla.test.core.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.senla.test.core.api.Controller;
import com.senla.test.core.api.Service;
import com.senla.test.core.impl.CoreController;
import com.senla.test.core.impl.CoreService;
import com.senla.test.core.util.Dispatcher;

public class CoreModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(Dispatcher.class).in(Singleton.class);
		bind(Controller.class).to(CoreController.class);
		bind(Service.class).to(CoreService.class);
	}

}
