package com.senla.test.core.impl;

import java.util.Map;
import java.util.stream.Collectors;

import com.google.inject.Inject;
import com.senla.test.core.api.Controller;
import com.senla.test.core.api.Service;

public class CoreController implements Controller{
	
	private Service service;
	
	@Inject
	public CoreController(Service service){
		this.service = service;
	}

	@Override
	public String expand(Map<String, String> map) {
		Integer number = Integer.valueOf(map.get("number"));
		return service.expand(number).stream ().map (i -> i.toString ()).collect (Collectors.joining (","));
	}

}
