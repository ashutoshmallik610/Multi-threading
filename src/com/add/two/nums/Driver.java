package com.add.two.nums;

public class Driver {

	public static void main(String[] args) {

		Task task = new Task();
		
		MyThread myThread = new MyThread(task);
		
		Thread thread = new Thread(myThread);
		
		thread.start();
	}

}
