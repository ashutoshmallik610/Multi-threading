package com.methods1.completable;

import java.util.concurrent.*;

public class CompletableFutureExample {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(3);

		try {
			// 1. supplyAsync() - Execute tasks asynchronously
			CompletableFuture<String> productFuture = CompletableFuture.supplyAsync(() -> {
				sleep(1000);
				return "Samsung Galaxy S26";
			}, executor);

			CompletableFuture<Integer> stockFuture = CompletableFuture.supplyAsync(() -> {
				sleep(1500);
				return 50;
			}, executor);

			CompletableFuture<Double> priceFuture = CompletableFuture.supplyAsync(() -> {
				sleep(800);
				return 79999.0;
			}, executor);

			// 2. thenApply() - Transform the result
			CompletableFuture<String> formattedProduct = productFuture.thenApply(name -> "Product: " + name);

			// 3. thenCombine() - Combine results of two futures
			CompletableFuture<String> productDetails = formattedProduct.thenCombine(stockFuture,
					(product, stock) -> product + ", Stock: " + stock);

			// 4. thenAccept() - Consume the result without returning one
			productDetails.thenAccept(System.out::println);

			// 5. thenCompose() - Chain dependent asynchronous tasks
			CompletableFuture<String> productWithPrice = productFuture.thenCompose(
					name -> CompletableFuture.supplyAsync(() -> name + ", Price: ₹" + priceFuture.join(), executor));

			// 6. allOf() - Wait for multiple futures to complete
			CompletableFuture<Void> allTasks = CompletableFuture.allOf(productFuture, stockFuture, priceFuture);

			allTasks.thenRun(() -> System.out.println("All API calls completed.")).join();

			System.out.println(productWithPrice.join());

			// 7. exceptionally() - Handle exceptions with a fallback
			CompletableFuture<Object> errorFuture = CompletableFuture.supplyAsync(() -> {
				throw new RuntimeException("Service unavailable");
			}, executor).exceptionally(ex -> "Fallback: " + ex.getMessage());

			System.out.println(errorFuture.join());

			// 8. handle() - Handle both success and failure
			CompletableFuture<String> handledFuture = CompletableFuture.supplyAsync(() -> "Order created")
					.handle((result, ex) -> {
						if (ex != null) {
							return "Order failed: " + ex.getMessage();
						}
						return "Success: " + result;
					});

			System.out.println(handledFuture.join());

			// 9. orTimeout() - Fail if the task exceeds the timeout
			CompletableFuture<String> timeoutFuture = new CompletableFuture<>();

			timeoutFuture.orTimeout(2, TimeUnit.SECONDS);

			// 10. getNow() - Read a completed result or return a default
			System.out.println(timeoutFuture.getNow("Still processing"));

		} finally {
			executor.shutdown();
		}
	}

	private static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(e);
		}
	}
}
