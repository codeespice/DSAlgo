package com.g.ds.java.datastructure;

import java.util.*;

public class SortApp {

    static class Person implements Comparable<Person>{
        private String name;
        private  int age;
        Person(String name,int age)
        {
            this.name=name;
            this.age=age;
        }

        @Override
        public int compareTo(Person o) {
            return this.name.compareTo(o.name);
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
    }
    public static void main(String[] args)
    {

        List<String> names = Arrays.asList("Demo","find","Alien");
        Collections.sort(names);
        names.forEach(x->System.out.println(x));

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("radha",23));
        persons.add(new Person("Alien",13458));
        persons.add(new Person("Rambo",34));
        persons.add(new Person("Dunkirk",36));
        //Collections.sort(persons);
        Collections.sort(persons,(a,b)->{return a.name.compareTo(b.name);});

        //persons.sort(Comparator.comparing(Person::getAge));
        persons.forEach(x->System.out.println(x.name+" "+x.age));

    }
}
