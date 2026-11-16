package com.bank.syn.nor;

class BankAccount {
	int balance = 1000;

	public /* synchronized */ void withdraw(int amount) 
	{
		// 1. Unsynchronized section (Before lock)
		System.out.println(
				Thread.currentThread().getName() + " - sending email notification.....requested the fund transfer");

		// Local variable to track if this specific thread's withdrawal succeeded
		boolean isSuccessful = false;

		// 2. Synchronized block: The critical section
		synchronized (this) {
			if (balance >= amount) {
				try 
				{
					Thread.sleep(100);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}

				balance = balance - amount;
				System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". Balance: " + balance);

				isSuccessful = true; // Mark as successful only if balance was deducted
			} 
			else {
				System.out
						.println(Thread.currentThread().getName() + " failed. Insufficient funds. Balance: " + balance);
			}
		}

		// 3. Unsynchronized section (Below lock): Conditional execution
		if (isSuccessful) {
			System.out.println(Thread.currentThread().getName()
					+ " - Transaction complete. Printing statement/receipt updates...");
		}
	}

	// Added static synchronized method below without modifying existing code
	public static synchronized void printBankRules() {
		System.out.println("Executing thread: " + Thread.currentThread().getName());
		System.out.println("Bank Rule: Every transaction must follow strict financial compliance regulations.");
	}
}
