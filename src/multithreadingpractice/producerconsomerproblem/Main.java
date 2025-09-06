package multithreadingpractice.producerconsomerproblem;

public class Main {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource(3);

        Thread producerThread = new Thread(() -> {

            for(int i = 0; i< 100; i++){
                sharedResource.produce(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            for(int i = 0; i< 100; i++){
                sharedResource.consume();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
