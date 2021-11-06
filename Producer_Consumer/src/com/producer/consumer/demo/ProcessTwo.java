package com.producer.consumer.demo;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

public class ProcessTwo implements Runnable {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	private LinkedBlockingQueue queue;
	public void setConsumer(LinkedBlockingQueue queue) {
		this.queue = queue;
	}
	
	@Override
	public void run()
	{
		try {
		logger.info("Consumer Thread Started");
		
		String receive="";
		
		while(true) {
			if(!queue.isEmpty()) {
			
			receive = queue.poll().toString();
			System.out.print(receive);
			
			System.out.println(" : Message has been received by Consumer");
			if(receive.equals("exit")) {
				
				break;
				}
			}
			
			Thread.sleep(100);
		}
		
		
		logger.info("Consumer thread shut down");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
