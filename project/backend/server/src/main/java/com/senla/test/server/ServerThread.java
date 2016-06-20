package com.senla.test.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.senla.test.core.util.Dispatcher;

public class ServerThread extends Thread {
	
	private static final Logger LOG = LogManager.getLogger(ServerThread.class);

	private PrintStream writer;
	private BufferedReader reader;
	private Dispatcher dispatcher;

	public ServerThread(Socket s, Dispatcher dispatcher) throws IOException {
		writer = new PrintStream(s.getOutputStream());
		reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
		this.dispatcher = dispatcher;
	}

	public void run() {
		String request;
		try {
			while ((request = reader.readLine()) != null) {
				try {
					writer.println(dispatcher.invoke(request));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					writer.println("Exception during execution");
				}
			}
		} catch (IOException e) {
			LOG.info(e.getMessage(), e);
			LOG.warn("disconnected");
		}  finally {
			disconnect();
		}
	}

	public void disconnect() {
		try {
			writer.close();
			reader.close();
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		} finally {
			this.interrupt();
		}
	}
}
