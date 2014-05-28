package com.example.java8;

/**
 *
 * @author DMEX38 
 *
 * https://en.wikipedia.org/wiki/Initialization_on_demand_holder_idiom
 *
 */
public class Singleton {

    private Singleton() {
    }

    private static class LazyHolder {

        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
