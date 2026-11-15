package com.lockfreemechanicm;

class Counter {
	volatile int count;

	/* AtomicInteger count = new AtomicInteger(0); */

	public /* synchronized */ void increseCount() {
		count++;
		/* count.incrementAndGet(); */
	}

	public int getCount() {
		return count /* count.get() */;
	}

}

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Counter counter = new Counter();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 200; i++) {
				counter.increseCount();
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 200; i++) {
				counter.increseCount();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println(counter.getCount());

	}

}
