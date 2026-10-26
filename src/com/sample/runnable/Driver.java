package com.sample.runnable;

class Task implements Runnable

{
	@Override
	public void run()
	{
		System.out.println("Task.run().....................");
	}
}

public class Driver {

	public static void main(String[] args) {
		
		Task task = new Task();
		
		Thread t = new Thread(task);
		
		t.start();
	}

}
