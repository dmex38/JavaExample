package com.example.java8;

import java.util.Collections;
import java.util.Spliterators;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 *
 * @author DMEX38 
 */
public class Streams {

    public void loop() {
        IntStream.rangeClosed(1, 10).forEach(num -> System.out.print(num));

        Stream stream = StreamSupport.stream(Spliterators.spliteratorUnknownSize(Collections.emptyIterator(), 0), false);

    }

}
