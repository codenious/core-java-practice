package multithreadingpractice.monitorlockexample;

public class Main {

    public static void main(String[] args) {


        System.out.println("Starting main thread: " + Thread.currentThread().getName());

       SharedResource sharedResource = new SharedResource();

        //Thread t1 = new Thread(new ProducerTask(sharedResource));
       //// Thread t2 = new Thread(new ConsumerTask(sharedResource));

       // t1.start();
       // t2.start();

        System.out.println("Main method ends");

            Thread consumerThread = new Thread(() -> {
                    System.out.println("Consuming the item:" + Thread.currentThread().getName());
                     sharedResource.consumeItem();
            });

            Thread producerThread = new Thread(() -> {
                System.out.println("Producing item in: " + Thread.currentThread().getName());
                try{
                    Thread.sleep(10000);
                } catch(InterruptedException e){
                    throw new RuntimeException(e);
                }
                sharedResource.addItem();
            });

            producerThread.start();
            consumerThread.start();

    }
}
