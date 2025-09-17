package multithreadingpractice.locks.semaphorelocks;

public class Main {

    public static void main(String[] args) {


        SharedResource rs = new SharedResource();

        Thread t1 = new Thread(rs::producer,"Thread 1");
        Thread t2 = new Thread(rs::producer,"Thread 2");
        Thread t3 = new Thread(rs::producer,"Thread 3");
        Thread t4 = new Thread(rs::producer,"Thread 4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
