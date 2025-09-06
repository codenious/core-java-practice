package multithreadingpractice;

public class CreatingThreadUsingTheadClass extends Thread{


    @Override
    public void run() {
        System.out.println("Getting starting with Thread: " + Thread.currentThread().getName());
    }
}
