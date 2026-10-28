package com.pro.consumer;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSystem {
	public static void main(String[] args) 
	{
		System.out.println("--- Restaurant System Started ---");

		// The shared resource created in the main thread
		List<String> sharedCounter = new ArrayList<String>();
		int limit = 3;

		// Instantiate the Runnables and pass the shared resource via constructors
		Chef chefTask = new Chef(sharedCounter, limit);
		Driver driverTask = new Driver(sharedCounter);

		// Pass the tasks to the Thread objects
		Thread chefThread = new Thread(chefTask);
		Thread driverThread = new Thread(driverTask);

		// Start both threads
		chefThread.start();
		driverThread.start();
	}
}