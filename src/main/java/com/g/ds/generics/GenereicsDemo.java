package com.g.ds.generics;

import java.util.Arrays;

public class GenereicsDemo {
    public static void main(String args[])
    {
       Student[] students = new Student[10];
       Student s1 = new Student(1,"demo1");
        Student s2 = new Student(2,"demo2");
        Student s3 = new Student(3,"demo3");
        Student s4 = new Student(4,"demo4");
        Student s5 = new Student(5,"demo5");
        students[0]=s1;
        students[1]=s2;
        students[2]=s1;
        students[3]=s2;
        students[4]=s1;

        Arrays.stream(students).forEach((x)->{
            if(x!=null)
                System.out.println(x);
        });

        /* No array for generics*/
    // Entry<String,String> entrees = new Entry<String,String>[10];
    }
}
