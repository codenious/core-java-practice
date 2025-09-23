package src.singleton;
/*
*
* This singleton class is synchronized but
* putting synchronized keyword has made it slow as what if
* there are so many threads and we need the singleton object back to back.
* Due to class level lock , A single will be able to access it.
* How to make it fast? We can use double check locking
*
*
*
*
* */
public class SynchronizedSingleton {

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton(){

    }

    public static synchronized SynchronizedSingleton getInstance(){
        if(instance == null){
            instance = new SynchronizedSingleton();
        }

        return instance;
    }
}
