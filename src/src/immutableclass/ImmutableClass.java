package src.immutableclass;
/*
* Make class Final
* Make Variable as Private and Final
* Instantiate the variable so they can only be set once
* No setter methods
* In getter methods, return defensive copies or copies of mutable Objects
* Example of Immutable Objects: - String, Instance, Wrapper Classes etc
*
* */
import java.util.ArrayList;
import java.util.List;

public final  class ImmutableClass {

    private final String name;
    private final List<String> pets;

    ImmutableClass(String name, List<String> pets){
        this.name = name;
        this.pets = new ArrayList<>(pets);
    }

    public String getName(){
        return name;
    }

    public List<String> getPetsList(){
        return new ArrayList<>(pets);
    }
}
