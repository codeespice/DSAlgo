package com.g.ds.sorting;

import java.util.Arrays;
/*
Three steps
1. heapSort
2. build heap (max or min) --> creates max/min heap from array
3. heapify: similar to build max heap but assumes part of array already sorted

procedure
1. create max heap
2. Remove largest item
3. place item in sorted partition
 */
public class HeapSort {

    public static void buildheap(int []arr) {

        /*
         * As last non leaf node will be at (arr.length-1)/2
         * so we will start from this location for heapifying the elements
         * */
        for(int i=(arr.length-1)/2; i>=0; i--){
            heapify(arr,i,arr.length-1);
        }
    }

    public static void heapify(int[] arr, int i,int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int max;
        if(left <= size && arr[left] > arr[i]){
            max=left;
        } else {
            max=i;
        }

        if(right <= size && arr[right] > arr[max]) {
            max=right;
        }
        // If max is not current node, exchange it with max of left and right child
        if(max!=i) {
            exchange(arr,i, max);
            heapify(arr, max,size);
        }
    }

    public static void exchange(int[] arr,int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static int[] heapSort(int[] arr) {

        buildheap(arr);
        int sizeOfHeap=arr.length-1;
        for(int i=sizeOfHeap; i>0; i--) {
            exchange(arr,0, i);
            sizeOfHeap=sizeOfHeap-1;
            heapify(arr, 0,sizeOfHeap);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={1,10,16,19,3,5};
        System.out.println("Before Heap Sort : ");
        System.out.println(Arrays.toString(arr));
        arr=heapSort(arr);
        System.out.println("=====================");
        System.out.println("After Heap Sort : ");
        System.out.println(Arrays.toString(arr));
    }
}
