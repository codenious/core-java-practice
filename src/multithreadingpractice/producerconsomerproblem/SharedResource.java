package multithreadingpractice.producerconsomerproblem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> buffer;
    private int bufferSize;

    public SharedResource( int bufferSize){
        buffer =new LinkedList<>();
        this.bufferSize = bufferSize;

    }

    public synchronized  void produce(int item){

        while(buffer.size() == bufferSize){

            System.out.println("Buffer is full. Waiting for it to be Empty");
            try{
                wait();
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        buffer.add(item);
        System.out.println("Item produced: " + item);
        notifyAll();
    }

    public synchronized  int consume(){

        while(buffer.isEmpty()){

            System.out.println("Queue is empty: " );
            try{
                wait();
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        int item = buffer.poll();
        System.out.println("Item consumed: " + item);
        //If producer thread is wating

        notifyAll(); //It makes the wait Thread in runnable state but still need to acquire lock to run
        return item;

    }
}
