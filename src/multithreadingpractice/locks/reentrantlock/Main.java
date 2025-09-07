package multithreadingpractice.locks.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        Resource rs1 = new Resource();

        Resource rs2 = new Resource();

       ReentrantLock lock = new ReentrantLock();

        //ReentrantLock lock1 = new ReentrantLock();

        //Lock Object is same but resource Objects are different and still we are able to attain locks on critical section without Monitor locks and synchronized block
        Thread t1 = new Thread(() -> {
            rs1.producer(lock);
        });

        Thread t2 = new Thread(() -> {
            rs2.producer(lock);
        });

        t1.start();
        t2.start();
    }
}
