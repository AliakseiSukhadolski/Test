package com.senla.test.ui.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleUtil {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsoleUtil.class);
	
	public static String readCommand(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String result = null;
		try {
			result = br.readLine();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public static void writeMessage(String message){
		System.out.println(message);
	}

}
