package com.add.two.nums;

public class MyThread implements Runnable{

	Task task;
	
	public MyThread(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {
		
		System.out.println(task.addTwoNums(5, 5));
		
	}

}
