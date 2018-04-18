package com.g.ds.sorting;
/*
1.find the pivot element
2.devide left array and devide right array
3. arrange such that all the left elements are less than pivot and right side elements are greater than pivot elements
4.Do the same process for left section and right section

 */
public class QuickSort {
    int low;
    int high;
    int[] array;

   public void sort(int[] array)
    {
        if(array==null || array.length==0)
        {
            return ;
        }
        this.array=array;
        sort(0,array.length-1);
    }

    private void sort(int low,int high)
    {
        int i=low;
        int j=high;
        int pivot = array[low+(high-low)/2];


        while(i<=j)
        {
            while(array[i]<pivot)
            {
                i++;
            }
            while(array[j]>pivot)
            {
                j--;
            }
            if(i<=j)
            {
                int temp =array[i];
                array[i] =array[j];
                array[j]=temp;
                i++;
                j--;

            }
        }
        if(low<j) {
            sort(low, j);
        }
        if(i<high)
        {
            sort(i,high);
        }


    }


    public static void main(String args[])
    {

        int[] myarray ={5,3,8,9};
        QuickSort qs = new  QuickSort();
        qs.sort(myarray);
       for(int i=0;i<myarray.length;i++)
       {
           System.out.println(myarray[i]);
       }
    }

}
