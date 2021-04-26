package com.ravi.collections.sort;

import java.util.*;
import java.util.stream.Collectors;

public class SortingAMap {

    //https://www.baeldung.com/java-sorting
    public static void main(String[] args) {
        HashMap<Integer, String> testMap = new HashMap<>();
        testMap.put(5, "Student5");
        testMap.put(3, "Student2");
        testMap.put(1, "Student4");
        testMap.put(6, "Student1");
        testMap.put(2, "Student3");
        testMap.put(4, "Student9");
        testMap.put(8, "Student7");
        testMap.put(7, "Student6");
        testMap.put(9, "Student8");

        //Sort by Key
        Map<Integer, String> sortedMapByKey = testMap.entrySet()
                .stream()
                //Sort using default comparator which uses natural order byt Key.
                //You can also pass custom copmarator as argument for comparingByKey(customcomparator)
                .sorted(Map.Entry.comparingByKey())
                // now create a new map to move the sorted map by key
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMapByKey);

        //Sort by Value
        Map<Integer, String> sortedMapByValue = testMap.entrySet()
                .stream()
                //Sort using default comparator which uses natural order by Value.
                //You can also pass custom copmarator as argument for comparingByValue(customcomparator)
                .sorted(Map.Entry.comparingByValue())
                // now create a new map to move the sorted map by key
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMapByValue);
    }

}
