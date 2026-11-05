package com.re_entrant.lock;

public class MyThread extends Thread
{	
	Task task;
	
	public MyThread(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run()
	{
		task.doSomething();
	}
}
