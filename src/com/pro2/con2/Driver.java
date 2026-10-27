package com.pro2.con2;

public class Driver {

	public static void main(String[] args) {

		Task task = new Task();

		Producer producer1 = new Producer(task);
		Producer producer2 = new Producer(task);

		Consumer consumer1 = new Consumer(task);
		Consumer consumer2 = new Consumer(task);

		Thread p1 = new Thread(producer1, "Producer-1");
		Thread p2 = new Thread(producer2, "Producer-2");

		Thread c1 = new Thread(consumer1, "Consumer-1");
		Thread c2 = new Thread(consumer2, "Consumer-2");

		p1.start();
		p2.start();

		c1.start();
		c2.start();
	}
}