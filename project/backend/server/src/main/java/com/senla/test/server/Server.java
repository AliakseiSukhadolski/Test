package com.senla.test.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;
import com.senla.test.core.util.Dispatcher;

public class Server {
	
	private static final Logger LOG = LogManager.getLogger(Server.class);
	
	private Dispatcher dispatcher;
	
	@Inject
	public Server(Dispatcher dispatcher){
		this.dispatcher = dispatcher;
	}
	
	public void start(){
		ServerSocket serv = null;
		try {
			serv = new ServerSocket(8071);
			while (true) {
				Socket sock = serv.accept();
				ServerThread server = new ServerThread(sock, dispatcher);
				server.start();
			}
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		} finally {
			if(null != serv){
				try {
					serv.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
