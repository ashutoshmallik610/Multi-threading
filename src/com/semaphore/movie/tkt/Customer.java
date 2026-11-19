package com.semaphore.movie.tkt;

public class Customer extends Thread {

    private TicketCounter counter;

    public Customer(TicketCounter counter, String name) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.bookTicket(getName());
    }
}
