package com.senla.test.client;

import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
	private Socket socket;
			
	public Client(){
		init();
	}
	
	private void init(){
		try {
			socket = new Socket(InetAddress.getLocalHost(), 8071);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public Socket getSocket(){
		return socket;
	}
			
}
