package com.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Driver {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

//		CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
//			
//			System.out.println(Thread.currentThread().getName());
//			return 20;
//		}).thenApplyAsync((n) -> 
//		{
//			System.out.println(Thread.currentThread().getName());
//			return n * 10;
//		}).thenApplyAsync((n) -> 
//		{
//			System.out.println(Thread.currentThread().getName());
//			
//			return n * 5;
//		});	
//
//		System.out.println(completableFuture.get());
		
		//CF1
		CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
			
			System.out.println(Thread.currentThread().getName());
			return 20;
		}).thenApplyAsync((n) -> 
		{
			System.out.println(Thread.currentThread().getName());
			return n * 10;
		});
		
		//CF2
		CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 
		{
			System.out.println(Thread.currentThread().getName());
			return 30;
		}).thenApplyAsync((n) -> 
		{
			System.out.println(Thread.currentThread().getName());
			return n * 10;
		});
		
		//Combine the results....
		CompletableFuture<Integer> finalCF = cf2.thenCombine(cf1, (a, b) -> a + b);
		
		System.out.println(finalCF.get());
	}
}
