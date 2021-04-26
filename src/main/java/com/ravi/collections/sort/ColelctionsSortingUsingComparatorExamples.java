package com.ravi.collections.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColelctionsSortingUsingComparatorExamples {

    //https://www.baeldung.com/java-sorting
    public static void main(String[] args) {
        List<Student> school = new ArrayList<>();
        Student student1 = new Student(59, "John", 20);
        Student student2 = new Student(67, "Roger", 22);
        Student student3 = new Student(45, "Steven", 24);
        school.add(student1);
        school.add(student2);
        school.add(student3);

        System.out.println("Before Sorting : " + school);
        Collections.sort(school);
        System.out.println("After Sorting : " + school);
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
