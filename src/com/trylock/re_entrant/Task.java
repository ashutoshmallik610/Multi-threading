package com.trylock.re_entrant;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class Task {
    private final ReentrantLock lock = new ReentrantLock();

    public void doWork() {
        try {
            // Try to acquire the lock within 2 seconds
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + " secured the lock.");
                    
                    // Simulate long work (4 seconds). This forces Thread-2 to time out!
                    Thread.sleep(4000); 
                    
                } finally {
                    lock.unlock(); // Always unlock when done
                    System.out.println(Thread.currentThread().getName() + " released the lock.");
                }
            } else {
                // Lock wasn't available within 2 seconds.
                System.out.println(Thread.currentThread().getName() + " timed out. Performing fallback tasks...");
                performOtherTasks(); 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void performOtherTasks() {
        System.out.println(Thread.currentThread().getName() + " is safely doing OTHER works now.");
    }
}
