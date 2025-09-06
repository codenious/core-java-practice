package multithreadingpractice;

public class CreatingThreads implements  Runnable{
    @Override
    public void run() {
        System.out.println("Thread running for:  " + Class.class + Thread.currentThread().getName());
    }
}
