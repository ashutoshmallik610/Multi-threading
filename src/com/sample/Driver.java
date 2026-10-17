package com.sample;

class MyThread implements Runnable
{

	@Override
	public void run() {

		System.out.println("Inside run.....");
		try
		{
			System.out.println("Thread is going to sleep...");
			Thread.sleep(5000);
			System.out.println("Sleep time over....");
		}
		catch (InterruptedException e) 
		{
			e.getMessage();
		}
		System.out.println("Completed Run....");
	}

//	@Override
//	public void run() {
//		System.out.println("Running MyThread");
//		
//	}
	
}

public class Driver {

	public static void main(String[] args) {
		
		
		MyThread myThread = new MyThread();
		
		Thread th = new Thread(myThread);
		
		th.start();
		th.start();
		
		try
		{
			System.out.println("Interrupt is going to disturb you........");
			Thread.sleep(5000);
			System.out.println("Disturbed Successfully....");
		}
		catch (InterruptedException e) 
		{
			e.getMessage();
		}
		
		th.interrupt();
		 
	}

}
