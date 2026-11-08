package com.thred.set.name1;


class MyThread extends Thread
{
	@Override
	public void run()
	{
		System.out.println("Run method executed by : "+Thread.currentThread().getName()); 
		System.out.println("Run method priority : "+Thread.currentThread().getPriority());	//main thread 
	}
}

public class Driver {

	public static void main(String[] args) {

		
		MyThread t = new MyThread();
		
		t.setPriority(7);
		
		t.start();
		
		t.setName("Thread - 1");
		
		System.out.println("Main method executed by : "+Thread.currentThread().getName());	//main thread 
		
//		Thread.currentThread().setPriority(15);	//Exception priority will be between 1 to 10
		System.out.println("Main method priority : "+Thread.currentThread().getPriority());	//main thread 
	}

}
