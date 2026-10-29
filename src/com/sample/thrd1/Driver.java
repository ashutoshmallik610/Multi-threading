package com.sample.thrd1;

class MyThread extends Thread
{
	@Override
	public void run()
	{
		System.out.println("Run() method is executed by : ["+Thread.currentThread().getName()+"] thread.");
	}
}
public class Driver {

	public static void main(String[] args) {

		System.out.println("Driver.main()..........Start");
		
		System.out.println("Main() method is executed by : ["+Thread.currentThread().getName()+"] thread.");
		
		MyThread t1 = new MyThread();
		
		t1.setPriority(10);
		t1.start();
		
		MyThread t2 = new MyThread();
		t2.start();
		
		MyThread t3 = new MyThread();
		t3.start();
		

		System.out.println("Driver.main()..........End");
	}

}
