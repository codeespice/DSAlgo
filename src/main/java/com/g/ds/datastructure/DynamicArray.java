package com.g.ds.datastructure;

import java.util.Arrays;

public class DynamicArray<T> {

    Object[] arrayObject;
    int size;
    public DynamicArray(int initialSize)
    {
        size=0;
        arrayObject = new Object[initialSize];
    }
    public T getElement(int index)
    {
        return (T)arrayObject[index];
    }
    public void putElement(T obj)
    {
        ensureCapacity(size+1);
        arrayObject[size++]=obj;
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
            System.out.println("Current size is "+ size);
            System.out.println("resize Happend and new Capacity is "+ newCapacity);

        }
    }

    public static void main(String[] args)
    {

        DynamicArray<Integer> dynamicArray= new DynamicArray<>(2);
        dynamicArray.putElement(2);
        dynamicArray.putElement(3);
        dynamicArray.putElement(4);
        dynamicArray.putElement(5);
        dynamicArray.putElement(6);
        dynamicArray.putElement(8);
        dynamicArray.putElement(9);
        dynamicArray.putElement(10);
        dynamicArray.putElement(12);
        dynamicArray.putElement(14);

    }

}
