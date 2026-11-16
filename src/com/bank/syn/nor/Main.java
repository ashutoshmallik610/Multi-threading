package com.bank.syn.nor;

public class Main 
{
	public static void main(String[] args) 
	{
		// Create one single shared bank account
		BankAccount sharedAccount = new BankAccount();

		// Create two distinct thread instances pointing to the SAME account
		WithdrawTask t1 = new WithdrawTask(sharedAccount, 600, "Thread-1");
		WithdrawTask t2 = new WithdrawTask(sharedAccount, 600, "Thread-2");

		// Start both threads concurrently
		t1.start();
		t2.start();
	}
}
