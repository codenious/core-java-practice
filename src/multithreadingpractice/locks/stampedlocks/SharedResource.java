package multithreadingpractice.locks.stampedlocks;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    int a = 10;
    public void producer(StampedLock lock){
        Long stamp = lock.tryOptimisticRead();
        try{
            a = 15;
            System.out.println("Optimistic read : " + Thread.currentThread().getName());
            System.out.println("Value of a is: " + a);
            Thread.sleep(10000);
            if(lock.validate(stamp)){
                System.out.println("Value updated successfully" + a);
            } else {
                System.out.println("Perform rollback");
                stamp = lock.readLock();
                a= 10;
            }

        } catch (InterruptedException e){

            throw new RuntimeException(e);
        } finally {
            lock.unlock(stamp);
            System.out.println("Producer lock released by " + Thread.currentThread().getName());
        }
    }

    public void consumer(StampedLock lock){

        long stamp = lock.writeLock();
        try{
            System.out.println("Locked taken by: " + Thread.currentThread().getName());
            a = 15;
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock(stamp);
            System.out.println("Lock unlocked by : " + Thread.currentThread().getName());
        }

    }
}
