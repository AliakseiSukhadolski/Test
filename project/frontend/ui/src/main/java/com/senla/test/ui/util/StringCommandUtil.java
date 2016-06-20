package com.senla.test.ui.util;

import com.senla.test.ui.command.Command;

public class StringCommandUtil {
	
	private static final String SPACE = " ";

	public static String convertToBasicView(String stringCommand, Command command){
		return command.getName() + SPACE + stringCommand;
	}

}
