package com.trylock.re_entrant;


public class MyThread extends Thread {   
    private final Task task;
    
    public MyThread(Task task, String name) {
        super(name); // Set the custom name of the thread
        this.task = task;
    }

    @Override
    public void run() {
        task.doWork();
    }
}
