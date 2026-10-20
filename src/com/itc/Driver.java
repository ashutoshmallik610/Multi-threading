package com.itc;

public class Driver {

	public static void main(String[] args) {
		
		Task task = new Task();
		
		Producer producer = new Producer(task);
		Consumer consumer = new Consumer(task);
		
		consumer.start();
		producer.start();
		
	}

}
