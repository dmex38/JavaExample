package com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DMEX38
 */
public class Simple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Main Thread :" + Thread.currentThread().getName());

        //Executor
        ExecutorService single = Executors.newSingleThreadExecutor();
        single.submit(new MyRunnable());

        single.shutdown();

        //
        System.out.println("Simple Runnable:");
        System.out.println("----------------------");
        new Thread(new MyRunnable()).start();
        //
        System.out.println("Simple Thread extends:");
        System.out.println("----------------------");
        new MyThread().start(); //Start Thread

    }

    /**
     * First solution : extend class Thread
     */
    public static class MyThread extends Thread {

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " I'm running !!!");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " I'm finished...");
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * Second solution implements Runnable
     */
    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " I'm running !!!");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " I'm finished...");
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
