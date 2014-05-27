package com.example.javaexample;

import java.util.Arrays;

/**
 *
 * @author dmex38
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello world");
        
        Arrays.asList("TOTO","TITI","TATA").forEach(System.out::println);
    }
    
}
