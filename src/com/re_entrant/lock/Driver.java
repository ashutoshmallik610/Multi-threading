package com.re_entrant.lock;

public class Driver {

	public static void main(String[] args) {
		
		Task task = new Task();
		
		MyThread t1 = new MyThread(task);
		
		t1.start();
		
		MyThread t2 = new MyThread(task);
		
		t2.start();
	}
}
