package com.joinn;

class Mythread extends Thread
{	
	
	@Override
	public void run()
	{
		for(int i = 0; i < 10;i++)
		{
			System.out.println("Child Thread");	//Executed by child thread
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
}

public class Driver {

	public static void main(String[] args) {


		Mythread t = new Mythread();
		
		t.start();
		
		try 
		{
			t.join();	//t.join(5000); within 5 sec child thread must be execute otherwise Main thread will execute
		} 
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	
		
		for(int i = 0; i < 10;i++)
		{
			System.out.println("Main Thread");	//Executed by main thread
		}

	}

}

