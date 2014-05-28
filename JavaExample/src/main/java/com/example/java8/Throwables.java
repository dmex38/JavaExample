package com.example.java8;

import java.util.concurrent.Callable;

/**
 *
 * @author DMEX38 
 */
public interface Throwables {

    @FunctionalInterface
    public static interface ExceptionWrapper<E> {

        E wrap(Exception e);
    }

    public static <T> T propagate(Callable<T> callable) throws RuntimeException {
        return propagate(callable, RuntimeException::new);
    }

    public static <T, E extends Throwable> T propagate(Callable<T> callable, ExceptionWrapper<E> wrapper) throws E {
        try {
            return callable.call();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw wrapper.wrap(e);
        }
    }

}
