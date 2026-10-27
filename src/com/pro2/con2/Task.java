package com.pro2.con2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Task {

	private final int capacity = 5;
	private int buffer = 0;

	private final ReentrantLock lock = new ReentrantLock();

	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	public void produce() throws InterruptedException {

		lock.lock();

		try {
			while (buffer == capacity) {
				System.out.println("Buffer full - Producer waiting...");
				notFull.await();
			}

			System.out.println("Before Producer producing data Buffer is : " + buffer);

			buffer++;

			System.out.println("Producer produced data");
			System.out.println("Buffer : " + buffer);

			notEmpty.signal();

		} finally {
			lock.unlock();
		}
	}

	public void consume() throws InterruptedException {

		lock.lock();

		try {
			while (buffer == 0) {
				System.out.println("Buffer empty - Consumer waiting...");
				notEmpty.await();
			}

			System.out.println("Before Consumer consuming data Buffer is : " + buffer);

			buffer--;

			System.out.println("Consumer consumed data");
			System.out.println("Buffer : " + buffer);

			notFull.signal();

		} finally {
			lock.unlock();
		}
	}
}