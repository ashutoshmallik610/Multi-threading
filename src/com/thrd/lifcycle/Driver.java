package com.thrd.lifcycle;

class EmailSender extends Thread
{
	@Override
	public void run()
	{
		//When Thread is in RUNNING state ---->
		//Thread is doing work
		//From RUNNING to WAITING/BLOCKED
		//Once WAITING is over move to RUNNABLE state
		//Once CPU allows, thread moved to RUNNING state
		//Once run() method is completed by thread, then it moves to TERMINATED state
		System.out.println("Sending ................. email.");
	}
}
public class Driver {

	public static void main(String[] args) {
	
		//Once Thread object created then State === NEW
		EmailSender t1 = new EmailSender();
		
		//State === RUNNABLE
		t1.start(); // Once CPU gives time to execute/run then state === RUNNING 
		//------------ >>>>> TERMINATED 
	}

}
