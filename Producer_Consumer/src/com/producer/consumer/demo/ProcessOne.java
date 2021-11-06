package com.producer.consumer.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

public class ProcessOne extends Thread 
{
	private LinkedBlockingQueue queue;
	public void setMessageProducer(LinkedBlockingQueue queue) {
		this.queue = queue;
	}
	
	private Logger logger = Logger.getLogger(this.getName());
	@Override
	public void run()
	{
		try {
		logger.info("Producer Thread Started");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = reader.readLine()) != null) {
			
			queue.add(input);
			System.out.print(input);
			System.out.println(" : Message has been send by Producer");
			if(input.equals("exit"))
				break;
		}
		
		
		logger.info("Producer shuting down");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}


