package com.senla.test.ui.exception;

public class NotValidParamException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3152663464593708043L;
	
	public NotValidParamException(String message, Exception e){
		super(message, e);
	}
	
	public NotValidParamException(String message){
		super(message);
	}

}
