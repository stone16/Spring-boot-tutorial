package com.llchen.msgwithredis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * In any messaging based application, there are message publishers and message receivers
 */
public class Receiver {

    private static final Logger log = LoggerFactory.getLogger(Receiver.class);

    // make sure that a task waits for other threads before it starts
    private CountDownLatch latch;

    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String msg) {
        log.info("Receive: <" + msg + " >");
        latch.countDown();
    }
}
