package com.g.ds.dynamicprogramming;
/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

Solution:
Sequence Problem so you have to have two for loops ;
one for the main array and other for subset of the arrays

this kind of dynamic problem has no common pattern , you need to look at previous values to
determine the max value

Algorithm

Initialize an array dp with length nums.length and all elements equal to 1. dp[i] represents the length of the longest increasing subsequence that ends with the element at index i.

Iterate from i = 1 to i = nums.length - 1. At each iteration, use a second for loop to iterate from j = 0 to j = i - 1 (all the elements before i). For each element before i, check if that element is smaller than nums[i]. If so, set dp[i] = max(dp[i], dp[j] + 1).

Return the max value from dp.
 */
public class LongestIncreasingSubSequence {

    public int lengthOfLIS(int[] nums){
        if(nums.length==0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] =1; //base case, LIS at first element has length 1
        int maxans =1 ; //global LIS length

        for(int i=1;i<dp.length;i++){
            int maxVal =0;//length of LIS that ends on i
            for(int j=0;j<i ;j++){ //consider all values before i
                if(nums[i]>nums[j]){ //we only care if current value is greater than previous value
                    maxVal = Math.max(maxVal,dp[j]); //Check with LIS at previous value
                }
            }
            dp[i] = maxVal+1; //We have the LIS at i, save it in DP
            maxans = Math.max(maxans,dp[i]); //possibly update global LIS length
        }
        return maxans;

    }

    public static void main(String[] args){

        int[] nums = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubSequence subSequence = new  LongestIncreasingSubSequence();
        int result =  subSequence.lengthOfLIS(nums);
        System.out.println("result:"+result);

    }
}
