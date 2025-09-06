package multithreadingpractice;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Getting started with main method " + Thread.currentThread().getName());
        //Runnable Implementation
//        CreatingThreads ct = new CreatingThreads();
//        Thread t1 = new Thread(ct);
//        t1.start();
//        t1.join();

        //Using Thread Class

        CreatingThreadUsingTheadClass ctc = new CreatingThreadUsingTheadClass();
        ctc.start();  //We could call the start method directly because its a subclass to thread and has capabilities of thread class
        System.out.println("Getting finished with main method " + Thread.currentThread().getName());




    }
}
