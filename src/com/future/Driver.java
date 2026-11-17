package com.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Driver {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// Future requires an explicit thread pool to manage execution
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// Step 1: Supply the initial value (Equivalent to supplyAsync)
		Future<Integer> future1 = executor.submit(() -> {
			System.out.println(Thread.currentThread().getName());
			return 20;
		});

		// Step 2: Process the first result (Equivalent to the first thenApplyAsync)
		// We must call .get() on the first future, which blocks until it is ready
		Future<Integer> future2 = executor.submit(() -> {
			System.out.println(Thread.currentThread().getName());
			return future1.get() * 10;
		});

		// Step 3: Process the final result (Equivalent to the second thenApplyAsync)
		// We call .get() on the second future, blocking again
		Future<Integer> finalFuture = executor.submit(() -> {
			System.out.println(Thread.currentThread().getName());
			return future2.get() * 5;
		});

		// Print the final output (1000)
		System.out.println(finalFuture.get());

		// Shut down the executor service to stop the application threads
		executor.shutdown();
	}
}
