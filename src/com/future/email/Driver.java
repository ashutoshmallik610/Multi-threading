package com.future.email;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task implements Callable<Boolean>
{
	EmailSender emailSender;
	
	public Task(EmailSender emailSender)
	{
		this.emailSender = emailSender;
	}
	
	@Override
	public Boolean call()
	{
		System.out.println("Executing call()");
		return emailSender.sendEmail(emailSender.email, emailSender.body);
	}
}


public class Driver {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		System.out.println("Main Thread - Start");
		
		ExecutorService ex = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 5; i++) {
			
			EmailSender emails = new EmailSender("jatin"+i+"@gamil.com", "email body "+i+" sent.");
			
			Task task = new Task(emails);
			
			Future<Boolean> future = ex.submit(task);
			
			System.out.println("Email sent status is : "+future.get());
		}
		
		System.out.println("Main Thread - End");
		
		ex.shutdown();
	}
}
