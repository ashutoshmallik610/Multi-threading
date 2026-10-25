package com.runnablee;

class MyRunnable implements Runnable
{
	
	@Override
	public void run()
	{
		for(int i = 0; i < 10;i++)
		{
			System.out.println("Child Thread");	//Executed by child thread
		}
	}
}

public class Driver {

	public static void main(String[] args) {


		MyRunnable r = new MyRunnable();
		
		Thread t1 = new Thread(r);
		
		t1.start();
		
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
