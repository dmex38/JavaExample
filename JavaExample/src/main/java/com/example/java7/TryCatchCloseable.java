package com.example.java7;

import java.io.Closeable;

/**
 *
 * @author DMEX38 
 */
public class TryCatchCloseable {

    static class MyStream implements Closeable {

        void read() {
            System.out.println("Read.");
        }

        @Override
        public void close() {
            System.out.println("Close.");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try (MyStream stream = new MyStream()) {
            stream.read();
        }

    }
}
