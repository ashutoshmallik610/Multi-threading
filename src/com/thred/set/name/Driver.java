package com.thred.set.name;

class MyThread extends Thread
{
	
}

public class Driver {

	public static void main(String[] args) {

		System.out.println(Thread.currentThread().getName());
		
		Thread.currentThread().setName("Thread-Main");
		
		System.out.println(Thread.currentThread().getName());
		
		MyThread t = new MyThread();
		
		System.out.println(t.getName());
		
		t.setName("Thread - 1");
		
		System.out.println(t.getName());
	}

}
