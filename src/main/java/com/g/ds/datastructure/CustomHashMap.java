package com.g.ds.datastructure;

import java.util.Arrays;

public class CustomHashMap<K ,V> {
    private int DEFAULT_CAPACITY;
    private int SIZE=10;

    public CustomHashMap( )
    {

    }

    static class Node<K,V>
    {

        K key;
        V value;
        Node next;
        Node(K key,V value)
        {
            this.key=key;
            this.value=value;

        }
    }
    Node<K,V>[] arrayObject = new Node[SIZE];

    public void put(K key,V value)
    {
       // Node node = new Node(key,value);
        int userHash = key.hashCode();
        int hash = getSupplementalHash(userHash);
        int bucketNumber = getBucketNumber(hash);
       // ensureCapacity(SIZE+1);
        Node node = arrayObject[bucketNumber];
        if(node==null)
        {
            node = new Node(key,value);

        }
        else
        {

            Node currentNode =node;
            //Search for duplicates if not add element at the end
            while(currentNode.next!=null)
            {
                if(currentNode.key.equals(key))
                {
                    currentNode.value=value;
                    System.out
                            .println("duplicate key value pair, replacing existing key "
                                    + key + ", with value " + value);
                    return;
                }
                currentNode = currentNode.next;
            }
            currentNode.next = new Node(key,value);

        }
        arrayObject[bucketNumber]=node;





    }

    public V get(K key)
    {
        int userHash = key.hashCode();
        int hash = getSupplementalHash(userHash);
        int bucketNumber = getBucketNumber(hash);
        Node currentNode = arrayObject[bucketNumber];
        while(currentNode!=null)
        {
            if(currentNode.key.equals(key))
            {
                return (V)currentNode.value;
            }
            currentNode=currentNode.next;
        }
        return null;


    }
    public void ensureCapacity(int minimumCapacity)
    {
        int oldCapacity = arrayObject.length;
        //if we need capacity more than existing then double the size
        if(minimumCapacity>oldCapacity)
        {
            //double the size
            int newCapacity = oldCapacity*2;
            if(newCapacity<minimumCapacity)
            {
                newCapacity= minimumCapacity;
            }
            arrayObject= Arrays.copyOf(arrayObject,newCapacity);
            System.out.println("Current size is "+ SIZE);
            System.out.println("resize Happend and new Capacity is "+ newCapacity);

        }
    }
    private int getSupplementalHash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int getBucketNumber(int hash) {
        return hash & (SIZE - 1);
    }


    public static void main(String[] args)
    {
        class Employee {
            private Integer id;
            private String name;

            Employee(Integer id, String name) {
                this.id = id;
                this.name = name;
            }

            @Override
            public int hashCode() {
                // this ensures all hashcodes are between 0 and 15
                return id % 10;
            }

            @Override
            public boolean equals(Object obj) {
                Employee otherEmp = (Employee) obj;
                return this.name.equals(otherEmp.name);
            }

            @Override
            public String toString() {
                return this.id + "-" + name;
            }
        }


        CustomHashMap<Employee,String> customHashMap = new CustomHashMap<>();
        Employee e1_dup1 = new Employee(100, "Niranjan");
        Employee e1_dup2 = new Employee(101, "Devender");
        Employee e1_dup3 = new Employee(102, "Bhadri");
        Employee e1_dup4 = new Employee(103, "Gnani");
        Employee e1_dup5 = new Employee(103, "Remo");
        customHashMap.put(e1_dup1, "dept101");
        customHashMap.put(e1_dup2, "dept102");
        customHashMap.put(e1_dup3, "dept103");
        customHashMap.put(e1_dup4, "dept104");


      //  String dept = customHashMap.get(e1_dup5); //null condition
         String dept = customHashMap.get(e1_dup4);

        System.out.println("dept is "+dept);

    }

}
