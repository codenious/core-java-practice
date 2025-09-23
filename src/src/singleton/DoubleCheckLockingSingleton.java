package src.singleton;

public class DoubleCheckLockingSingleton {


    private static volatile DoubleCheckLockingSingleton instance;

    private DoubleCheckLockingSingleton(){

    }

    public static DoubleCheckLockingSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckLockingSingleton.class){
                if(instance ==null){
                    instance = new DoubleCheckLockingSingleton();
                }
            }
        }

        return instance;
    }
}
