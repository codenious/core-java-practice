package multithreadingpractice.threadpools.differentThreadpools;

import java.util.concurrent.*;

public class FixedThreadPoolExample {

    public static void main(String[] args) {


        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        Future<String> future = fixedThreadPool.submit(() -> {
            return "Himanshu";
        });

        CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> "Himanshu " + Thread.currentThread().getName(), fixedThreadPool);

        CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> "Tyagi" + Thread.currentThread().getName(), fixedThreadPool);

        CompletableFuture<String> combinedObj  = asyncTask1.thenCombine(asyncTask2, (String val1, String val2) -> val1 + val2);
        try {
            System.out.println(combinedObj.get());
        } catch(ExecutionException | InterruptedException e){
            System.out.println("Either Interrupted or Execution Exception happened");
        }
        catch(Exception e){
            System.out.println("Exception Occurred");
        }



    }
}
