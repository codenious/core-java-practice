package multithreadingpractice.atomics;

import java.util.concurrent.atomic.AtomicInteger;

public class ExampleWithAtomic {


    static AtomicInteger counter = new AtomicInteger();


    public static void main(String[] args) throws InterruptedException{


        int incrementPerThread = 200_000;
        int threads = 4;
        Thread[] ts = new Thread[threads];

        for(int t = 0; t< threads; t++){

            ts[t] = new Thread(() -> {
                for(int i = 0; i< incrementPerThread; i++){
                    counter.incrementAndGet();
                    if(i%100 == 0)  Thread.yield();
                }
            });
        }
        for(Thread thread: ts){
            thread.start();
        }

        for(Thread thread : ts){
            thread.join();

        }

        System.out.println("Expected counter:  " + threads*incrementPerThread + " Actual counter: " + counter);

    }
}
