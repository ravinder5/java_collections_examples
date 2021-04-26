package com.ravi.collections.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingACustomObject {

    //https://www.baeldung.com/java-sorting
    public static void main(String[] args) {
        List<Student> school = new ArrayList<>();
        Student student1 = new Student(59, "Jon", 20);
        Student student2 = new Student(67, "Doe", 22);
        Student student3 = new Student(45, "Foo", 24);
        Student student4 = new Student(45, "Bar", 24);
        school.add(student1);
        school.add(student2);
        school.add(student3);
        school.add(student4);

        System.out.println("Before Sorting : " + school.toString());
        Collections.sort(school);
        System.out.println("After Sorting : " + school.toString());

        // Sort the arraylist with name
        school.sort(Comparator.comparing(Student::getName));
        System.out.println("After Sorting with Name : " + school.toString());

        // Sort the arraylist with Age
        school.sort(Comparator.comparing(Student::getAge));
        System.out.println("After Sorting with Age : " + school.toString());

        // Sort the arraylist with Rank but because both Foo and Bar have same Age, we can use Name to further sort as below
        school.sort(Comparator.comparing(Student::getRank).thenComparing(Student::getName));
        System.out.println("After Sorting with Rank first then with Name : " + school.toString());
    }

    private static class Student implements Comparable<Student> {
        private int rank;
        private String name;
        private int age;

        public Student(int rank, String name, int age) {
            this.rank = rank;
            this.name = name;
            this.age = age;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Student compareToStudent) {
            // This makes rank the natural order for this object
            return Integer.compare(getRank(), compareToStudent.getRank());
        }

        @Override
        public String toString() {
            return "Student{" +
                    "rank=" + rank +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
