package src.singleton;

//Eager Initialization. Why? Because you are creating Object in Advance.
/*
* 1. Object creation is private and static
* 2. Constructor is private
* 3. We are simply returning the instance.
*
* Disadvantage? We are creating Object no matter if we use it or not. Taking memory.
* That's why we want Lazy Initialization
* */
public class EagerInitializationSingleton {

    private static final EagerInitializationSingleton sc = new EagerInitializationSingleton();

    private EagerInitializationSingleton(){

    }

    public static EagerInitializationSingleton getInstance(){
        return sc;
    }
}
