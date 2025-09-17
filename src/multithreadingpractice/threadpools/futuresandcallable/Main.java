package multithreadingpractice.threadpools.futuresandcallable;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        Future<?> futureObj = getFuture();

        System.out.println(futureObj.isDone());

        try{
            futureObj.get(5,TimeUnit.SECONDS);
        } catch(TimeoutException r){
            System.out.println("Timeout Happened");
        } catch(InterruptedException | ExecutionException e){
            throw new RuntimeException(e);
        }

        try{
            futureObj.get();
        } catch(InterruptedException | ExecutionException e ){
            throw new RuntimeException(e);
        }

        System.out.println("Is done? " + futureObj.isDone());
        System.out.println("Is cancelled? " + futureObj.isCancelled());


    }

    private static Future<?> getFuture() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(2),
                new MyCustomThreadFactory(),
                new MyCustomRejectionHandler()
        );


        Future<?> futureObj = executor.submit(() -> {
            try{
                Thread.sleep(5000);
                System.out.println("Thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        });
        return futureObj;
    }


}

class MyCustomRejectionHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: " + r.toString());
    }
}

class MyCustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        return th;
    }
}
