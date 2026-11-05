package com.re_entrant.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Task
{
	ReentrantLock lock = new ReentrantLock();
	
	public void doSomething()
	{
		
		lock.lock();
		
		for (int i = 0; i < 10; i++) {
			
			System.out.println(i +" Executed by : "+Thread.currentThread().getName());
		}
		lock.unlock();
	}
}
