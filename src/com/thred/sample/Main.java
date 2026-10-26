package com.thred.sample;

class Mythread extends Thread
{	
	//if we override start method then run method will not execute........
	//call the start() of Thread class by using super.start()
	
//	@Override
//	public void start()
//	{
//		
//		super.start();
//		System.out.println("Mythread------------start method");
//	}
	
	@Override
	public void run()
	{
		for(int i = 0; i < 10;i++)
		{
			System.out.println("Child Thread");	//Executed by child thread
		}
	}
}

public class Main {

	public static void main(String[] args) {


		Mythread t = new Mythread();
		
//		t.setPriority(10);
		
		t.start();
		
//		try {
//			t.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		for(int i = 0; i < 10;i++)
		{
			System.out.println("Main Thread");	//Executed by main thread
		}

	}

}
