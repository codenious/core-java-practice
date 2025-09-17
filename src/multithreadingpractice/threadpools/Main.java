package multithreadingpractice.threadpools;

import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) {


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor (
                2,
                4,
                5,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(2),
                new MyCustomThreadFactor(),
                new MyCusmtomRejectionHandler());


        for(int start = 0; start < 7; start++){
            Future<?> future = threadPoolExecutor.submit(() -> {

              try{
                  Thread.sleep(5000);
                  System.out.println("Thread: " + Thread.currentThread().getName());
                } catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
            });
        }


        threadPoolExecutor.shutdown();


    }








   }

class MyCustomThreadFactor implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        return th;

    }
}

class MyCusmtomRejectionHandler implements  RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: " + r.toString());
    }
}
