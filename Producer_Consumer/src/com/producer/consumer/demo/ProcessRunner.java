package com.producer.consumer.demo;

import java.util.concurrent.LinkedBlockingQueue;

public class ProcessRunner {

	public static void main(String[] args) {

		  LinkedBlockingQueue queue = new LinkedBlockingQueue();
		  ProcessOne one = new ProcessOne();
		  one.setMessageProducer(queue);
		  
		  ProcessTwo two = new ProcessTwo();
		  two.setConsumer(queue);
		  Thread tTwo = new Thread(two);
		  
		  
		  tTwo.start();
		  one.start();

	}

}
