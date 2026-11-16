package com.bank.syn.nor;

class WithdrawTask extends Thread
{
    BankAccount account;
    int amount;

    // Constructor to pass the shared account and the withdrawal amount
    WithdrawTask(BankAccount account, int amount, String threadName) 
    {
        super(threadName); // Sets the thread name
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() 
    {
        account.withdraw(amount); // Executes the withdrawal
//        BankAccount.printBankRules();
    }
}

