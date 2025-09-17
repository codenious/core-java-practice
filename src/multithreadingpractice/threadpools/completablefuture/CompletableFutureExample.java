package multithreadingpractice.threadpools.completablefuture;

import java.util.concurrent.*;

public class CompletableFutureExample {

    public static void main(String[] args) {


        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                new MyCustomThreadFactory(),
                new MyCustomRejectionHandler()
        );

        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {


            try {
                System.out.println("Thread is sleeping: " + Thread.currentThread().getName());
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Himanshu ";
//ThenApply uses same thread and thenApplyAsync uses different thread if we have not passed any executor then it will use fork join pool
        }, executor).thenApplyAsync((String value) -> {
            System.out.println("Then Apply Thread: " + Thread.currentThread().getName());
            return value + "Tyagi";
        }).thenApplyAsync((String val) -> {
            System.out.println("Then Apply Thread: " + Thread.currentThread().getName());
            return val + ". His ";
        }).thenApplyAsync((String val) -> {
            System.out.println("Then Apply Thread: " + Thread.currentThread().getName());
            return val + "work ";
        }).thenApplyAsync((String val) -> {
            System.out.println("Then Apply Thread: " + Thread.currentThread().getName());
            return val + "is ";
        }).thenApplyAsync((String val) -> {
            System.out.println("Then Apply Thread: " + Thread.currentThread().getName());
            return val + "to learn ";
        }).thenApplyAsync((String val) -> {
            System.out.println("Then Apply Thread: " + Thread.currentThread().getName());
            return val + "IT. ";
        });

        System.out.println("Main continous working...");

        String name = null;
        try {
            name = result.get();
        } catch (Exception e) {
            System.out.println("Exception happened");
        }

        System.out.println(name);

    }





}


class MyCustomRejectionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected: " + r.toString());
    }
}

class MyCustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        return th;
    }
}
