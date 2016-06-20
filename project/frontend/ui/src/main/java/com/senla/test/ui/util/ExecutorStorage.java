package com.senla.test.ui.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorStorage {
	
	private static final int DEFAULT_SIZE = 5;
	
	private ExecutorService executor;
	
	public ExecutorStorage(int size){
		init(size);
	}
	
	public ExecutorStorage(){
		init(DEFAULT_SIZE);
	}
	
	private void init(int size){
		executor = Executors.newFixedThreadPool(size);
	}
	
	public <T extends Thread> void execute(T thread){
		executor.execute(thread);
	}
	
	public void shutdown(){
		executor.shutdown();
	}

}
