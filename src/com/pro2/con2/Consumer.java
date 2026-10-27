package com.pro2.con2;

public class Consumer implements Runnable {

	Task task;

	public Consumer(Task task) {
		this.task = task;
	}

	@Override
	public void run() {

		try {

			for (int i = 1; i <= 10; i++) {

				task.consume();

				Thread.sleep(800);
			}

		} catch (InterruptedException e) {

			Thread.currentThread().interrupt();
		}
	}
}