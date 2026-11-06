package com.semaphore.sample;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(2);

		for (int i = 1; i <= 5; i++) {

			int threadNumber = i;

			Thread thread = new Thread(() -> {

				try {
					// Take a permit
					semaphore.acquire();

					System.out.println("Thread " + threadNumber + " entered");

					Thread.sleep(2000);

					System.out.println("Thread " + threadNumber + " leaving");

				} catch (InterruptedException e) {
					e.printStackTrace();

				} finally {
					// Return the permit
					semaphore.release();
				}

			});

			thread.start();
		}
	}
}
