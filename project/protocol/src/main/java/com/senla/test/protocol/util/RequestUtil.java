package com.senla.test.protocol.util;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.senla.test.protocol.context.CommandContext;


public class RequestUtil {
	
	private static final String KEY_VALUE_SEPARATOR = "=";
	private static final String DELIMETER = "&";

	public static String buildRequest(CommandContext context){
		 String result = context.getContext().entrySet()
		            .stream()
		            .map(entry -> entry.getKey() + KEY_VALUE_SEPARATOR + entry.getValue())
		            .collect(Collectors.joining(DELIMETER));
		
		return context.getCommandName() + DELIMETER + result;
	}
	
	
	public static CommandContext parseRequest(String request){
		CommandContext result = new CommandContext();
		String[] parsed = request.split(DELIMETER);
		result.setCommandName(parsed[0]);
		Map<String, String> context = new HashMap<String, String>();
		for(int i = 1; i < parsed.length; i++){
			String[] params = parsed[i].split(KEY_VALUE_SEPARATOR);
			context.put(params[0], params[1]);
		}
		result.setContext(context);
		return result;
	}
	
}
