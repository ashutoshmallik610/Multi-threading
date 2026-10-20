package com.itc;

public class Task {

	int data;
	boolean isDataAvailable = false;
	
	public synchronized void produce(int _data) throws InterruptedException
	{
		while(isDataAvailable)
		{
			wait();
		}
		this.data = _data;
		
		System.out.println("Produced the data : "+data+" Thread name : "+Thread.currentThread().getName());
		isDataAvailable = true;
		
		System.out.println("Producer notifying the consumer");
		notify();
	}
	
	public synchronized void consume() throws InterruptedException
	{
		while(!isDataAvailable)
		{
			wait();
		}
		
		System.out.println("Consuming the data : "+data+" Thread name : "+Thread.currentThread().getName());
		isDataAvailable = false;
		
		System.out.println("Consumer notifying the producer");
		notify();
	}
}
