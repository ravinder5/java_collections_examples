package com.ravi.collections.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExamples {

    public static void main(String[] args) {

//        Supplier<String> i = () -> "Car";
//        Consumer<String> c = x -> System.out.println(x.toLowerCase());
//        Consumer<String> d = x -> System.out.println(x.toUpperCase());
//        c.andThen(d).accept(i.get());
//        System.out.println();


        List<Integer> list = Arrays.asList(1,2,3,4,5);

        //find min value in list
        System.out.println(list.stream().min(Integer::compareTo).get());
        //find max value in list
        System.out.println(list.stream().max(Integer::compareTo).get());
        //filter even numbers
        List<Integer> evenNumbers = list.stream().filter(i -> i%2==0).collect(Collectors.toList());
        System.out.println(evenNumbers.toString());
        //filter and get count
        System.out.println(list.stream().filter(i -> i%2==0).count());

        //prints yellow
        System.out.println(Stream.of("green","yellow","blue").max((s1,s2) -> s1.compareTo(s2)).filter(s -> s.endsWith("n")).orElse("yellow"));

    }

}
