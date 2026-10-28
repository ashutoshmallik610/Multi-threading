package com.pro.consumer;

import java.util.List;

// 1. Separate Class for the Chef Thread
public class Chef implements Runnable {
	private final List<String> counter;
	private final int maxCapacity;

	// Constructor to pass the shared resource
	public Chef(List<String> counter, int maxCapacity) {
		this.counter = counter;
		this.maxCapacity = maxCapacity;
	}

	@Override
	public void run() {
		int orderNumber = 1;
		try {
			while (true) {
				// SLEEP: Simulates the fixed time it takes to cook a meal
				System.out.println("[Chef] Cooking pizza #" + orderNumber + "...");
				Thread.sleep(2000);

				synchronized (counter) {
					// WAIT: If the counter is full, release lock and pause
					while (counter.size() == maxCapacity) {
						System.out.println("[Chef] Counter is FULL. Chef is WAITING...");
						counter.wait();
					}

					String meal = "Pizza #" + orderNumber++;
					counter.add(meal);
					System.out.println("[Chef] Placed " + meal + " on counter. Total items: " + counter.size());

					// Notify the driver that food is ready
					counter.notify();
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}