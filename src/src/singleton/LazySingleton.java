package src.singleton;
/* Instantiation of the Object is lazily as we are checking first if the instance exists or not
*  If it exists then we simply just return the Instance and if its null , We create the instance
*  and return it
*
*  Disadvantage:- It's memory saving, but it's not Thread safe. Multiple Thread can create multiple
*  instances
*
*
* */

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if(instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }


}
