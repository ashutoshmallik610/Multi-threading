package com.syn.method.sample;

class Task
{
	public synchronized void printNumbers()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Printing : "+i+" ["+Thread.currentThread().getName()+"]");
		}
	}
}
class PrintThread extends Thread
{
	Task task;

	public PrintThread(Task task) {
		super();
		this.task = task;
	}
	
	@Override
	public void run()
	{
		task.printNumbers();
	}
}

public class Driver {

	public static void main(String[] args) {

		Task task1 = new Task();
		
		PrintThread t1 = new PrintThread(task1);
		
		t1.setName("Thread - 1");
		
		t1.start();
		
		
		PrintThread t2 = new PrintThread(task1);
		
		t2.setName("Thread - 2");
		
		t2.start();
		
	}

}
