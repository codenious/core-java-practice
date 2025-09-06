package multithreadingpractice;

public class MonitorLockMain {

    public static void main(String[] args) {

       MonitorLockExample me = new MonitorLockExample();

       Thread t1 = new Thread(me::task1);
       Thread t2 = new Thread(me::task2);
       Thread t3 = new Thread(me::task3);
       t1.start();
       t2.start();
       t3.start();
    }
}
