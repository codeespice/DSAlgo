package com.g.ds.trivial;

public class MinumumLengthSubArray {

    public int minimumLengthSubArray(int[] array,int number)
    {
        int n1 = array.length;
        int res1 = smallestSubWithSum(array, n1, number);
        if (res1 == n1+1)
            return -1;
        else
            return res1;
    }

    public int smallestSubWithSum(int arr[], int n, int x)
    {
        // Initialize current sum and minimum length
        int curr_sum = 0, min_len = n + 1;

        // Initialize starting and ending indexes
        int start = 0, end = 0;
        while (end < n)
        {
            // Keep adding array elements while current sum
            // is smaller than x
            while (curr_sum <= x && end < n)
                curr_sum += arr[end++];

            // If current sum becomes greater than x.
            while (curr_sum > x && start < n)
            {
                // Update minimum length if needed
                if (end - start < min_len)
                    min_len = end - start;

                // remove starting elements
                curr_sum -= arr[start++];
            }
        }
        return min_len;
    }
    public static void main(String[] args)
    {
        int[] array = {2,3,1,2,4,3};
        int number =7;
        MinumumLengthSubArray minumumLengthSubArray = new MinumumLengthSubArray();
        int result=minumumLengthSubArray.minimumLengthSubArray(array,number);
        System.out.println("minimum length="+result);

    }
}
