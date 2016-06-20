package com.senla.test.core.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.google.inject.Inject;
import com.senla.test.core.api.Controller;
import com.senla.test.protocol.context.CommandContext;
import com.senla.test.protocol.util.RequestUtil;

public class Dispatcher {
	
	private final Controller controller;
	
	@Inject
	public Dispatcher(Controller controller){
		this.controller = controller;
	}
	
	
	public String invoke(String request) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		CommandContext context = RequestUtil.parseRequest(request);
		Class<?> clazz = controller.getClass();
		for(Method method : clazz.getMethods() ){
			if(method.getName().equals(context.getCommandName())){
				Object result = method.invoke(controller, context.getContext());
				return result.toString();
			}
		}
		return null;
	}
	
}
