package com.senla.test.core;

import java.lang.reflect.InvocationTargetException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.senla.test.core.api.Controller;
import com.senla.test.core.api.Service;
import com.senla.test.core.impl.CoreController;
import com.senla.test.core.impl.CoreService;
import com.senla.test.core.util.Dispatcher;
import com.senla.test.protocol.context.CommandContext;

public class CoreTest {
	private Injector injector;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		injector = Guice.createInjector(new AbstractModule() {

			@Override
			protected void configure() {
				bind(Dispatcher.class).in(Singleton.class);
				bind(Controller.class).to(CoreController.class);
				bind(Service.class).to(CoreService.class);
			}
		});
	}

	@After
	public void tearDown() throws Exception {
		injector = null;
	}

	@Test
	public void testDispatcher() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Dispatcher dispatcher = injector.getInstance(Dispatcher.class);
		Assert.assertEquals("2,2", dispatcher.invoke("expand&number=4"));
		Assert.assertNotEquals("2,3", dispatcher.invoke("expand&number=4"));
		exception.expect(InvocationTargetException.class);
		Assert.assertNotEquals("2,3", dispatcher.invoke("expand&number=test"));
	}
	
	@Test
	public void testController() {
		Controller controller = injector.getInstance(Controller.class);
		CommandContext context = new CommandContext();
		context.setCommandName("expand");
		context.getContext().put("number", "4");
		Assert.assertEquals("2,2", controller.expand(context.getContext()));
		Assert.assertNotEquals("2,3", controller.expand(context.getContext()));
		exception.expect(NumberFormatException.class);
		context.getContext().put("number", "null");
		controller.expand(context.getContext());
	}
	
	@Test
	public void testService() {
		Service service = injector.getInstance(Service.class);
		Assert.assertTrue(service.expand(4).size() == 2);
		Assert.assertTrue(service.expand(17).size() == 1);
		Assert.assertTrue(service.expand(34).size() != 1);
	}
	

}
