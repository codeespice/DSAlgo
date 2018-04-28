package com.g.ds.datastructure;
/*
https://www.youtube.com/watch?v=t0Cq6tVNRBA
 */
import java.util.Arrays;

public class MinHeap {

    private int capacity =10;
    private int size =0;
    private int[] items = new int[capacity];

    //get left index from array
    private int getLeftChildIndex(int parentIndex){
        return 2*parentIndex+1;
    }
    //get right index from array
    private int getRightChildIndex(int parentIndex){
        return 2*parentIndex+2;
    }
    //get parent index from array
    private int getParentIndex(int childIndex){
        return (childIndex-1)/2;
    }

    private boolean hasLeftChild(int index)
    {
       return getLeftChildIndex(index)<size;

    }
    private boolean hasRightChild(int index)
    {
        return getRightChildIndex(index)<size;

    }
    private boolean hasParent(int index)
    {
        return getParentIndex(index)>=0;

    }


    private int getLeftChild(int parentIndex)
    {
        return items[getLeftChildIndex(parentIndex)];
    }

    private int getRightChild(int parentIndex)
    {
        return items[getRightChildIndex(parentIndex)];
    }

    private int getParent(int childIndex)
    {
        return items[getParentIndex(childIndex)];
    }
    private void swap(int indexOne,int indexTwo)
    {
        int temp = items[indexOne];
        items[indexOne]=items[indexTwo];
        items[indexTwo]=temp;
    }
    private void ensureExtraCapacity()
    {
        if(size==capacity)
        {
            capacity=2*capacity;
            items= Arrays.copyOf(items,capacity);

        }
    }
    public int peek()
    {
        if(size==0) throw new IllegalStateException();
        return items[0];
    }
    public int poll()
    {
        if(size==0) throw new IllegalStateException();
        int item = items[0];
        items[0]=items[size-1];
        size--;
        heapifyDown();
        return item;

    }
    public void add(int item)
    {
        ensureExtraCapacity();
        items[size] =item;
        size++;
        heapifyUp();

    }

    private void heapifyUp()
    {
        int index = size-1;

        /*if parent element is less than current element
        swap the elements and proceed
         */
      while(hasParent(index) && items[getParentIndex(index)]<items[index])
      {

          swap(getParentIndex(index),index);
          index=getParentIndex(index);



      }

    }
    private void heapifyDown()
    {
        int index=0;
        /*
        since balance tree if there is a no left child then there is no right child

         */
        while(hasLeftChild(index))
        {
            int smallerChilindex= getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index)<getLeftChildIndex(index))
            {
                smallerChilindex = getRightChild(index);
            }
            if(items[index]>items[smallerChilindex])
            {
                break;
            }
            swap(smallerChilindex,index);
            index=smallerChilindex;

        }

    }
    public void printHeap()
    {
        for(int element: items)
        {
            System.out.print(element+"\t");
        }
    }
    public static void main(String[] args)
    {
        MinHeap minHeap = new MinHeap();
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(22);
        minHeap.add(15);
        minHeap.add(9);
        minHeap.printHeap();
        System.out.println("Polled:"+minHeap.poll());

     //   https://www.youtube.com/watch?v=t0Cq6tVNRBA

    }
}
