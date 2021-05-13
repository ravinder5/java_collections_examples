package com.ravi.collections.set;

import com.ravi.collections.sort.ColelctionsSortingUsingComparatorExamples;

import java.util.*;

public class SetExamples {

    public static void main(String[] args) {
        normalHashSet();
        // no equals() and hashcode()
        hashSetWithDuplicateObjectsandNoEqualsandHashcodeOverride();
        // overridden equals() and hashcode()
        hashSetWithDuplicateObjectsandHasEqualsandHashcodeOverride();
    }

    private static void hashSetWithDuplicateObjectsandHasEqualsandHashcodeOverride() {
        Student1 student11 = new Student1(59, "John", 20);
        Student1 student12 = new Student1(67, "Roger", 22);
        Student1 student13 = new Student1(45, "Steven", 24);
        Student1 student14 = new Student1(45, "Steven", 24);

        HashSet<Student1> testSet2 = new HashSet<>();
        testSet2.add(student11);
        testSet2.add(student12);
        testSet2.add(student13);
        testSet2.add(student14);
        testSet2.add(student13);
        // [Student{rank=45, name='Steven', age=24}, Student{rank=67, name='Roger', age=22}, Student{rank=59, name='John', age=20}]
        // output will have student11, student12, student13
        // Because we have implemented and overriden equals() and hashcode() methods student13 and student14 are treated as same objects and hence when we try to add student14 it will not be added to HashSet
        System.out.println(testSet2);
    }

    private static void hashSetWithDuplicateObjectsandNoEqualsandHashcodeOverride() {
        Student student1 = new Student(59, "John", 20);
        Student student2 = new Student(67, "Roger", 22);
        Student student3 = new Student(45, "Steven", 24);
        Student student4 = new Student(45, "Steven", 24);

        HashSet<Student> testSet1 = new HashSet<>();
        testSet1.add(student1);
        testSet1.add(student2);
        testSet1.add(student3);
        testSet1.add(student4);
        testSet1.add(student3);

        // [Student{rank=45, name='Steven', age=24}, Student{rank=45, name='Steven', age=24}, Student{rank=67, name='Roger', age=22}, Student{rank=59, name='John', age=20}]
        // output will have student1, student2, student3, student4
        // Note: you might be wondering why student4 is still allowed even though it has same values as student3. It is because we dont have hashcode() and equals() methods overridden in th student subclass.
        // if the object does not override equals() and hashcode() then two objects with same values are still treated as two different objects in HashSet
        System.out.println(testSet1);
    }

    private static void normalHashSet() {
        HashSet<String> testSet = new HashSet<>();
        testSet.add("Student5");
        testSet.add("Student2");
        testSet.add("Student4");
        testSet.add("Student1");
        testSet.add("Student3");
        testSet.add("Student1");

        //[Student3, Student4, Student5, Student1, Student2]
        System.out.println(testSet);
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

    private static class Student1 implements Comparable<Student1> {
        private int rank;
        private String name;
        private int age;

        public Student1(int rank, String name, int age) {
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
        public int compareTo(Student1 compareToStudent) {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student1 student1 = (Student1) o;
            return rank == student1.rank &&
                    age == student1.age &&
                    name.equals(student1.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(rank, name, age);
        }
    }
}
