package com.trylock.re_entrant;


public class Driver {
    public static void main(String[] args) {
        // Create the single shared task instance
        Task task = new Task();
        
        // Create two threads sharing the same task instance
        MyThread t1 = new MyThread(task, "Thread-1");
        MyThread t2 = new MyThread(task, "Thread-2");
        
        // Start the threads
        t1.start();
        
        // Give t1 a tiny head start to guarantee it grabs the lock first
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        t2.start();
    }
}

