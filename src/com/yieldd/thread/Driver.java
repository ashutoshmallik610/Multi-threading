package com.yieldd.thread;

class Mythread extends Thread
{	
	
	@Override
	public void run()
	{
		for(int i = 0; i < 10;i++)
		{
			System.out.println("Child Thread");	//Executed by child thread
			
			Thread.yield();	//main thread will get chance more number of time and the chance of completing main thread first is high
		}
	}
}

public class Driver {

	public static void main(String[] args) {


		Mythread t = new Mythread();
		t.start();
		
		for(int i = 0; i < 10;i++)
		{
			System.out.println("Main Thread");	//Executed by main thread
		}

	}

}
