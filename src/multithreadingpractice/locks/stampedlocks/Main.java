package multithreadingpractice.locks.stampedlocks;

import java.util.concurrent.locks.StampedLock;

public class Main {

    public static void main(String[] args) {

        StampedLock lock = new StampedLock();

        SharedResource rs = new SharedResource();

        Thread producer = new Thread(() -> {
            rs.producer(lock);
        });

        Thread consumer = new Thread(() -> {
            rs.consumer(lock);
        });

        producer.start();
        consumer.start();
    }
}
