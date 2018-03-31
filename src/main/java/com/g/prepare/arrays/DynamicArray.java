package com.g.prepare.arrays;

import java.util.Arrays;

public class DynamicArray<T> {

    Object[] arrayObject;
    int size;
    public DynamicArray()
    {
        size=0;
        arrayObject = new Object[1];
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

            System.out.println("resize Happend and new Capacity is "+ newCapacity);
            System.out.println("size is "+ size);
        }
    }

    public static void main(String[] args)
    {

        DynamicArray<Integer> dynamicArray= new DynamicArray<>();
        dynamicArray.putElement(2);
        dynamicArray.putElement(3);
        dynamicArray.putElement(4);
    }

}
