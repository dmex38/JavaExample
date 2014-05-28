package com.example.java7;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 *
 * @author DMEX38
 * @param <T>
 * #### NOT THREAD_SAFE ####
 */
public class Singleton<T> {

    private T instance;
    private final T defaultInstance;

    private final Class<T> clazz;

    public Singleton(Class<T> clazz, T defaultInstance) {
        this.clazz = clazz;
        this.defaultInstance = defaultInstance;
    }

    public T getDefault() {
        if (instance == null) {
            Iterator<T> service = ServiceLoader.load(clazz).iterator();
            if (service.hasNext()) {
                instance = service.next();
            } else {
                instance = defaultInstance;
            }
        }
        return instance;
    }

    public T set(T instance) {
        this.instance = instance;
        return instance;
    }

}
