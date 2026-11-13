package com.block.Future;

import java.util.concurrent.*;
import java.time.LocalTime;

public class FutureBlockingDemo 
{
	public static void main(String[] args) throws InterruptedException, ExecutionException 
	{
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		System.out.println("[" + LocalTime.now() + "] [" + 
					Thread.currentThread().getName() + "] Submitting task...");

		Future<String> future = executor.submit(() -> {
			Thread.sleep(2000); // Simulate a 2-second database call
			return "Data fetched successfully!";
		});

		// CRITICAL BLOCKING POINT:
		System.out.println("[" + LocalTime.now() + "] [" + Thread.currentThread().getName()
				+ "] Waiting for result (BLOCKING)...");
		
		String result = future.get(); // The main thread freezes here for 2 seconds!

		// This line cannot execute until the 2 seconds have passed
		System.out.println("[" + LocalTime.now() + "] [" + Thread.currentThread().getName() +
				"] Result received: " + result);

		executor.shutdown();
	}
}
