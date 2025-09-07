package multithreadingpractice.locks.reentrantlock.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    boolean isItemAvailable = false;

    public void produce(ReadWriteLock lock){

        try{
            lock.readLock().lock();
            System.out.println("Read lock taken by: " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        } finally {
            lock.readLock().unlock();
            System.out.println("Released lock by: " + Thread.currentThread().getName());
        }
    }

    public void consume(ReadWriteLock lock){

        try{
            lock.writeLock().lock();
            System.out.println("Write lock taken by : " + Thread.currentThread().getName());
            Thread.sleep(5000);
            isItemAvailable = true;
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        } finally {
            lock.writeLock().unlock();
            System.out.println("Released by: " + Thread.currentThread().getName());
        }

    }
}
