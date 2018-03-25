package com.g.prepare.sorting;

public class MergeSort {

    int[] array;
    private int[] tempArray;
    public MergeSort()
    {

    }

    public void sort(int[] array)
    {
        this.array=array;
        this.tempArray = new int[array.length];


        if(array==null|| array.length==0)
        {
            return;
        }
        mergeSort(0,array.length-1);

    }
    public void mergeSort(int low,int high)
    {
        if(low<high) {
            int i = low;
            int j = high;
            int middle = low + (high - low) / 2;

            mergeSort(low, middle);
            mergeSort(middle + 1,high);
            merge(low, middle, high);

        }

    }
    public void merge(int low,int middle,int high)
    {

        for(int i=low;i<=high;i++)
        {
            tempArray[i] =array[i];
        }

        int i=low;
        int j=middle+1;
        int k=low;
        while(i<=middle && j<=high)
        {
            if(tempArray[i]<=tempArray[j])
            {
                array[k]=tempArray[i];
                i++;
            }
            else
            {
                array[k]=tempArray[j];
                j++;
            }
            k++;
        }
        while(i<=middle)
        {
            array[k]=tempArray[i];
            k++;
            i++;

        }

    }
    public static void main(String args[])
    {
        int[] myarray ={3,2,8,9,19};
        MergeSort ms = new MergeSort();
        ms.sort(myarray);
        for(int i=0;i<myarray.length;i++)
        {
            System.out.println(myarray[i]);
        }

    }
}
