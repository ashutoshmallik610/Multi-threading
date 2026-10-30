package com.sample.sleeping;

class Task implements Runnable {

	@Override
	public void run() {

		for (int i = 1; i <= 10; i++) 
		{
			if (i == 5) 
			{
				try 
				{
					System.out.println("Sleeping.......................");
					
					Thread.sleep(4000);
					
					System.out.println("Sleeping time over..... i just woke up......sta");
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
			System.out.println("Printing : " + i);
		}
	}

}

public class Driver {

	public static void main(String[] args) {
		
		System.out.println("Driver.main()..................Start");
		
		Task task = new Task();
		
		Thread t = new Thread(task);
		
		t.start();
		
		System.out.println("Driver.main()..................End");
	}
}
