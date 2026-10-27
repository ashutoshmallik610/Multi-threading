package com.pro2.con2;

public class Producer implements Runnable {

	Task task;

	public Producer(Task task) {
		this.task = task;
	}

	@Override
	public void run() {

		try {

			for (int i = 1; i <= 10; i++) {

				task.produce();

				Thread.sleep(500);
			}

		} catch (InterruptedException e) {

			Thread.currentThread().interrupt();
		}
	}
}