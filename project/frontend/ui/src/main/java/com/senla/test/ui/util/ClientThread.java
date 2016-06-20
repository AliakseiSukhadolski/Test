package com.senla.test.ui.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.test.protocol.context.CommandContext;
import com.senla.test.protocol.util.RequestUtil;

public class ClientThread extends Thread{
	
	private static final Logger LOGGER = LogManager.getLogger(ClientThread.class);
	
	private CommandContext context;
	
	private Socket socket;
	
	public ClientThread(CommandContext context, Socket socket){
		this.context = context;
		this.socket = socket;
	}
	
	@Override
	public void run(){
		try {
			PrintStream ps = new PrintStream(socket.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ps.println(RequestUtil.buildRequest(context));
			ConsoleUtil.writeMessage(br.readLine());
		} catch (Exception e) {
			LOGGER.error("Failed to send message");
		}
	}
	
	
}
