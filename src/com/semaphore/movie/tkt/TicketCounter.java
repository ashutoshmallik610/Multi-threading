package com.semaphore.movie.tkt;

import java.util.concurrent.Semaphore;

public class TicketCounter {

    private Semaphore semaphore = new Semaphore(3);

    public void bookTicket(String customerName) {

        try {
            // Take a permit
            semaphore.acquire();

            System.out.println(customerName + " started booking");

            Thread.sleep(2000);

            System.out.println(customerName + " completed booking");

        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            // Return the permit
            semaphore.release();
        }
    }
}
