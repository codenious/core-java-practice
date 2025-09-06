package multithreadingpractice;

public class MonitorLockExample {

    public synchronized void task1()  {
        System.out.println("Task 1 started");
        try{
            Thread.sleep(10000);
        } catch (InterruptedException e){
            System.out.println( Thread.currentThread().getName() + " is Interrupted");
        }

        System.out.println("Task 1 completed after sleeping");
    }

    public void task2(){
        System.out.println("Task 2 starting..");
        synchronized (this){
            System.out.println("Task 2 running....");
        }
        System.out.println("Task 2 completed");
    }

    public void task3(){
        System.out.println("Task 3 completed");
    }
}
