package multithreadingpractice.locks.reentrantlock.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {

        System.out.println("Main thread started");

        SharedResource rs  = new SharedResource();

        SharedResource rs1 = new SharedResource();

        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread p = new Thread( ()-> {
            rs.produce(lock);
        });

        Thread c = new Thread(() -> {
            rs1.consume(lock);
        });



        p.start();
        c.start();

        System.out.println("Main thread finished");
    }
}
