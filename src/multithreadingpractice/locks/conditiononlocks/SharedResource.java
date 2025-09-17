package multithreadingpractice.locks.conditiononlocks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isItemAvailable = false;

    ReentrantLock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    public void produce(){

        try{
            lock.lock();
            System.out.println("Lock taken by " + Thread.currentThread().getName());
            if(isItemAvailable){
                System.out.println("Waiting for item to be consumed: " + Thread.currentThread().getName());
                condition.await();
            }  else {
                System.out.println("Produced the item: " +Thread.currentThread().getName());
                isItemAvailable = true;
                condition.signal();
                System.out.println("Signalled the consumer thread: " + Thread.currentThread().getName());
            }
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            System.out.println("Lock released by: " + Thread.currentThread().getName());
        }
    }

    public void consume(){

        try{
            lock.lock();
            System.out.println("Lock taken by Thread: " + Thread.currentThread().getName());
            if(!isItemAvailable){
                System.out.println("Waiting for item to be produced: " + Thread.currentThread().getName());
                condition.await();
            } else {
                System.out.println("item  consumed : " + Thread.currentThread().getName());
                isItemAvailable = false;
                condition.signal();
                System.out.println("Signalled the producing thread: "+ Thread.currentThread().getName());
            }
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            System.out.println("Lock released: " + Thread.currentThread().getName());

        }
    }
}
