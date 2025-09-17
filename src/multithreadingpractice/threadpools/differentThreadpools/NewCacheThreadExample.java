package multithreadingpractice.threadpools.differentThreadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCacheThreadExample {


    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
// Number of thread are increased dynamically as per need or task given.
        executor.submit(() -> {
            for(int i = 0; i< 300; i++){
                System.out.print(i + " ");
                System.out.println("Thread: name" + Thread.currentThread().getName());

            }
        });

        executor.submit(() -> {
            for(int i = 0; i< 300; i++){
                System.out.print(i + " ");
                System.out.println("Thread: name" + Thread.currentThread().getName());

            }
        });

        executor.submit(() -> {
            for(int i = 0; i< 300; i++){
                System.out.print(i + " ");
                System.out.println("Thread: name" + Thread.currentThread().getName());

            }
        });
    }
}
