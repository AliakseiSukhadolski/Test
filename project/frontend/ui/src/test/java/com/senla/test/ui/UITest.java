package com.senla.test.ui;

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
import com.senla.test.ui.command.CommandBuilder;
import com.senla.test.ui.command.CommandStorage;
import com.senla.test.ui.controller.api.Service;

public class UITest {
	
	private Injector injector;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		injector = Guice.createInjector(new AbstractModule() {

			@Override
			protected void configure() {
				bind(CommandStorage.class).in(Singleton.class);
				bind(CommandBuilder.class).in(Singleton.class);
				bind(Service.class).to(StubService.class);
			}
		});
	}

	@After
	public void tearDown() throws Exception {
		injector = null;
	}
	
	@Test
	public void testStorages() {
		CommandStorage commandStorage = injector.getInstance(CommandStorage.class);
		CommandBuilder builder = injector.getInstance(CommandBuilder.class);
		Assert.assertFalse(commandStorage.getDefaultCommand().equals(builder.getCommands().get("expand")));
		Assert.assertTrue(commandStorage.getCommandByKey("expand").getName().equals(builder.getCommands().get("expand").getName()));
	}


}
