package multithreadingpractice.locks.reentrantlock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

    Boolean itemAvailable = false;

    public void producer( ReentrantLock lock){

        try{
            lock.lock();
            System.out.println("Lock acquired: " + Thread.currentThread().getName());
            Thread.sleep(5000);
            itemAvailable = true;
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            System.out.println("Locked released by Thread: " + Thread.currentThread().getName());
        }


    }
}
