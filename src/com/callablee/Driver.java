package com.callablee;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyThread implements Callable<Integer>
{

	@Override
	public Integer call() {
		
		return 10;
	}
	
}


public class Driver {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		Future<Integer> result = executorService.submit(new MyThread());
		
		System.out.println(result.get());
		
		executorService.shutdown();
	}
}
