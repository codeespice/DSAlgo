package com.g.ds.arrays;
/*

Problem Statement
You are given an array of integers and a range of lowValue and highValue. The problem “Three way partitioning of an array around a given range” asks to partition the array such that array will be divided into three parts. The partitions of the arrays will be:

Elements of the first partition will be lesser than the lowValue,
Next partition such that elements lies within the given range will be in this partition and the
Numbers greater than the highValue will be the third partition of the array.


Solution:

We have given an integer array and a range of lowValue and highValue. We have to arrange the array or partition the array. Such that all the possible numbers of the array which are less than the lowValue will be on the left side of the array. And the number of the array which lies between the range of the array will be next in the array. And the next values will be the numbers which are greater than the highValue will be the last.

We will be traversing the array, from the 0th index to the last index. But before that, we have declared some variable and initialize it with the 0 and the last index of the array
 respectively. In swapping whenever the value lower than the lowValue is found,
 the operation will be performed on the startingValue and whenever the value greater than the highValue found,
 then the operation will be performed at endingValue. We will traverse the array and check if the current array element is
 less than the given lowValue if true then swap the current value of the array and the array first position value. This value we will keep track of the starting point
 and other value will keep the track of ending indexes for swapping the elements, another swap will be done if the element is found greater than the value of current array element.
  Then comes the endingValue, index at which the element is swapped with the current element. If none of the condition satisfies means the number lies within the given
   range then we do not change it. After the traversal completes, we have the desired array. We just need to print the array.


   Type: Actually we are calculating min and max for each and every element and storing the min index in min array and max index in max array.
   This type of problems we are creating arrays with indexes with specific purpose like calculating min and max in this scenario
 */
public class ThreeWayPartition {
    public static void getPartition(int[] arr, int lowValue, int highValue) {
        int n = arr.length;
        int startingValue = 0, endingValue = n - 1;
        for (int i = 0; i <= endingValue; ) {
            if (arr[i] < lowValue) {
                int temp = arr[startingValue];
                arr[startingValue] = arr[i];
                arr[i] = temp;
                startingValue++;
                i++;
            } else if (arr[i] > highValue) {
                int temp = arr[endingValue];
                arr[endingValue] = arr[i];
                arr[i] = temp;
                endingValue--;
            } else
                i++;
        }
    }
    public static void main (String[] args)
    {
        int arr[] = {2,5,87,56,12,4,9,23,76,1,45};
        getPartition(arr, 15, 30 );
        for (int i=0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
