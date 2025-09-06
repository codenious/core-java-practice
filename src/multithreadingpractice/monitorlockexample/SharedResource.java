package multithreadingpractice.monitorlockexample;

public class SharedResource {


    boolean itemAvailable = false;

    public synchronized void addItem(){
        itemAvailable = true;
        System.out.println("Item added: " + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized  void consumeItem(){

        System.out.println("Consuming item by thread: " + Thread.currentThread().getName());
        while(!itemAvailable){
            try {
                System.out.println("Waiting for item to get added in queue");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        itemAvailable = false;
        System.out.println("Consumed item: " + Thread.currentThread().getName());
    }
}
