package com.itc;

public class Producer extends Thread{

	Task task;
	
	public Producer(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				task.produce(i);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
