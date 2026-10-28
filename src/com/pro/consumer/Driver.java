package com.pro.consumer;

import java.util.List;

public class Driver implements Runnable {
    private final List<String> counter;

    // Constructor to pass the shared resource
    public Driver(List<String> counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String mealToDeliver;

                synchronized (counter) {
                    // WAIT: If counter is empty, release lock and pause
                    while (counter.isEmpty()) {
                        System.out.println("[Driver] Counter is EMPTY. Driver is WAITING...");
                        counter.wait(); 
                    }

                    mealToDeliver = counter.remove(0);
                    System.out.println("[Driver] Picked up " + mealToDeliver + ". Total remaining: " + counter.size());

                    // Notify the chef that a slot on the counter opened up
                    counter.notify();
                }

                // SLEEP: Simulates the fixed time it takes to deliver to the customer
                System.out.println("[Driver] Driving to deliver " + mealToDeliver + "...");
                Thread.sleep(5000); 
                System.out.println("[Driver] Successfully delivered " + mealToDeliver + "!");
            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
