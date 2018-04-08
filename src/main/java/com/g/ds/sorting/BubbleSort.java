package com.g.ds.sorting;
/*
We can create a java program to sort array elements using bubble sort. Bubble sort algorithm is known as the simplest sorting algorithm.

In bubble sort algorithm, array is traversed from first element to last element. Here, current element is compared with the next element. If current element is greater than the next element, it is swapped.
 */
public class BubbleSort {

    public void sort(int[] sortList)
    {
        int temp=0;
        for(int i=0;i<sortList.length;i++)
        {
            for(int j=0;j<sortList.length-1;j++)
            {
                if(sortList[j]>sortList[j+1])
                {
                    temp=sortList[j+1];
                    sortList[j+1]=sortList[j];
                    sortList[j]=temp;

                }
            }
        }

        for(int i=0;i<sortList.length;i++)
        {
            System.out.println(sortList[i]);
        }
    }

    public static void main(String args[])
    {
        int arr[] ={3,60,35,2,45,320,5};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
    }
}
