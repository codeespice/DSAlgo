package com.g.prepare.hash;

public class CustomHashMapTest {
    public static void main(String[] args) {
        CustomHashMap customHashmap = new CustomHashMap();
        Employee e1 = new Employee(100, "demo1");
        customHashmap.put(e1,"20");
        System.out
                .println("============== Adding Duplicate ===================");
        Employee e1_dup = new Employee(100, "demo");
        customHashmap.put(e1_dup,"25");

       Entry entry= customHashmap.get(e1);

       System.out.println("Key:"+entry.key);
        System.out.println("Value:"+entry.value);
    }
}
