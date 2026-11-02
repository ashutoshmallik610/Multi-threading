package com.future.email;

public class EmailSender {

	String email;
	String body;
	
	public EmailSender(String email, String body) {
		super();
		this.email = email;
		this.body = body;
	}
	
	public boolean sendEmail(String email, String body)
	{
		System.out.println("Email sending to : "+email+" ["+Thread.currentThread().getName()+"]");
		
		try {
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
