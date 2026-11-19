package com.semaphore.movie.tkt;

public class Main {

    public static void main(String[] args) {

        TicketCounter counter = new TicketCounter();

        Customer c1 = new Customer(counter, "Customer-1");
        Customer c2 = new Customer(counter, "Customer-2");
        Customer c3 = new Customer(counter, "Customer-3");
        Customer c4 = new Customer(counter, "Customer-4");
        Customer c5 = new Customer(counter, "Customer-5");

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}
