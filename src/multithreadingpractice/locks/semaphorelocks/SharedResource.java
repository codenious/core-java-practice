package multithreadingpractice.locks.semaphorelocks;

import java.util.concurrent.Semaphore;


public class SharedResource {

    Semaphore lock = new Semaphore(1);

    public void producer(){
       try{
           lock.acquire();
           System.out.println("Lock Acquired: " + Thread.currentThread().getName());
           Thread.sleep(5000);
       } catch(InterruptedException e){
           throw new RuntimeException(e);
       } finally {
           System.out.println("Lock released: " + Thread.currentThread().getName());
           lock.release();


       }
    }
}
