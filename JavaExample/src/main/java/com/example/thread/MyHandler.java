package com.example.thread;

/**
 *
 * @author dmex38
 */
public class MyHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        //log..
    }

    void newThread() {
        final Thread thread = new Thread(() -> {
            System.out.println("I'm the thread");
        });
        thread.setUncaughtExceptionHandler(new MyHandler());
    }

}
