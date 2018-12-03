package com.llchen.rabbitmq;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * For a messaging based application, we need to create a receiver that will respond to published messages.
 *
 * A POJO that defines a method for receiving messages
 */
@Component
public class Receiver {

    // A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
