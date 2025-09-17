package multithreadingpractice.threadpools.differentThreadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        //Single Thread only min = max = 1
        //Unbounded Queue
        //Keep alive when Idle
        //Disadvantage no concurrency
        //Use when we want to get executed sequentially

        executor.submit(() ->{
            System.out.println("Himanshu");
        });
    }
}
