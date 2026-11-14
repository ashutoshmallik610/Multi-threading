package com.thread.ppol.executer;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) {

        // Counts the number of threads created
        AtomicInteger threadCount = new AtomicInteger(0);

        // Creates custom-named threads
        ThreadFactory threadFactory = task -> {
            int count = threadCount.incrementAndGet();

            Thread thread = new Thread(
                    task, "backend-worker-" + count
            );

            System.out.println("Thread created: " + thread.getName());

            return thread;
        };

        // Custom thread pool
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                       // Core pool size
                4,                       // Maximum pool size
                60,                      // Keep-alive time
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );

        try {
            CompletableFuture<String> productFuture =
                    CompletableFuture.supplyAsync(() -> {
                        printThread();
                        sleep(1000);
                        return "Samsung Galaxy";
                    }, executor);

            CompletableFuture<Integer> stockFuture =
                    CompletableFuture.supplyAsync(() -> {
                        printThread();
                        sleep(1500);
                        return 100;
                    }, executor);

            CompletableFuture<Double> priceFuture =
                    CompletableFuture.supplyAsync(() -> {
                        printThread();
                        sleep(800);
                        return 79999.0;
                    }, executor);

            CompletableFuture<Void> allTasks =
                    CompletableFuture.allOf(
                            productFuture, stockFuture, priceFuture
                    );

            allTasks.join();

            System.out.println("Product: " + productFuture.join());
            System.out.println("Stock: " + stockFuture.join());
            System.out.println("Price: ₹" + priceFuture.join());

            System.out.println(
                    "Total threads created: " + threadCount.get()
            );

        } finally {
            executor.shutdown();
        }
    }

    private static void printThread() {
        System.out.println(
                "Executing on: " + Thread.currentThread().getName()
        );
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
