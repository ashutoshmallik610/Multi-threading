package com.own.even.odd.threadd;

class OddPrint implements Runnable
{
	@Override
	public void run()
	{
		for(int i = 1; i <= 20; i++)
		{
			if(i % 2 != 0)
			{
				System.out.println(i +"is executed by "+Thread.currentThread().getName());
			}
			if(i == 11)
			{
				try {
					System.out.println(Thread.currentThread().getName()+" is going to sleep");
					Thread.sleep(1000);
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" woken up");
			}
			
		}
	}
}

class EvenPrint implements Runnable
{
	@Override
	public void run()
	{
		for(int i = 1; i <= 20; i++)
		{
			if(i % 2 ==0)
			{
				System.out.println(i +"is executed by "+Thread.currentThread().getName());
			}
			if(i == 11)
			{
				try {
					System.out.println(Thread.currentThread().getName()+" is going to sleep");
					Thread.sleep(1000);
				} 
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+" woken up");
			}
			
		}
	}
}

public class Driver {

	public static void main(String[] args) {
		
		EvenPrint e = new EvenPrint();
		
		Thread t1 = new Thread(e);
		
		t1.setName("Even Thread");
		t1.start();
		
		OddPrint o = new OddPrint();
		
		Thread t2 = new Thread(o);
		
		t2.setName("Odd Thread");
		t2.start();

	}

}
