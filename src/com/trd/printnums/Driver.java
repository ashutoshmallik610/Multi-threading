package com.trd.printnums;

class PrintNumsUsingTwoThreads extends Thread 
{
	@Override
	public void run() {
		for (int i = 1; i <= 20; i++) {
			System.out.println(i + " is Ecxecuted by ---> " + Thread.currentThread().getName());
		}
	}
}

public class Driver {

	public static void main(String[] args) {

		PrintNumsUsingTwoThreads t1 = new PrintNumsUsingTwoThreads();
		t1.setName("Thread - 1");
		t1.start();

		PrintNumsUsingTwoThreads t2 = new PrintNumsUsingTwoThreads();
		t1.setName("Thread - 2");
		t2.start();

	}

}
