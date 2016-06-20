package com.senla.test.core.util;

public class ParseUtil {
	
	public static Object parseValue(String value, Class<?> clazz){
		if(clazz.isInstance(String.class)){
			return value;
		} else if (clazz.isInstance(Integer.class)){
			return Integer.valueOf(value);
		}
		return null;
	}

}
