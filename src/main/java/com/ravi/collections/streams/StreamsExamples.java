package com.ravi.collections.streams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsExamples {

    public static void main(String[] args) {
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

    }

}
