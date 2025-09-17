package multithreadingpractice.locks.conditiononlocks;

public class Main {

    public static void main(String[] args) {
        SharedResource rs = new SharedResource();

        Thread producer = new Thread(rs::produce,"Producer");
        Thread consumer = new Thread(rs::consume,"Consumer");
        producer.start();
        consumer.start();
    }
}
