package com.waiter.ex;

class Cooking extends Thread
{
	@Override
	public void run()
	{
		System.out.println("Food preparation is started ...."+Thread.currentThread().getName());
		
		try {
			sleep(2000);
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Food Preparation is done");
	}
}

public class Driver {

	public static void main(String[] args) {


		Thread.currentThread().setName("Waiter");
		System.out.println("Waiter took the order......"+Thread.currentThread().getName());
		
		Cooking c1 = new Cooking();
		c1.setName("Cook");
		c1.start();
		
		try {
			c1.join();	//waiter thread will wait till food is cooked
		}
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Waiter is serving the order ...."+Thread.currentThread().getName());

	}

}
