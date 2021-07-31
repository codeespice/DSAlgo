package com.g.ds.arrays;

import java.util.Arrays;

public class ThreeSumProblem {

/*
Problem:
                Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.



                Example 1:

                Input: nums = [-1,2,1,-4], target = 1
                Output: 2
                Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


                Constraints:

                3 <= nums.length <= 10^3
                -10^3 <= nums[i] <= 10^3
                -10^4 <= target <= 10^4
 */

    /*
   Algorithm:

            Initialize the minimum difference diff with a large value.
            Sort the input array nums.
            Iterate through the array:
            For the current position i, set lo to i + 1, and hi to the last index.
            While the lo pointer is smaller than hi:
            Set sum to nums[i] + nums[lo] + nums[hi].
            If the absolute difference between sum and target is smaller than the absolute value of diff:
            Set diff to target - sum.
            If sum is less than target, increment lo.
            Else, decrement hi.
            If diff is zero, break from the loop.
            Return the value of the closest triplet, which is target - diff.

     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum =0;
        for(int i =0;i<nums.length && diff!=0 ;i++){

            int lo = i+1;
            int high = nums.length-1;

            while(lo<high){
                sum = nums[i]+nums[lo]+nums[high];

                if(Math.abs(target-sum) < Math.abs(diff)){
                    diff = target-sum;
                }
                if(sum<target){
                    lo = lo+1;
                }
                else{
                    high = high-1;
                }

            }
        }
        return target-diff;

    }

    public static void main(String[] args){
        int[] nums = {-1,2,1,-4};
        int target = 1 ;
        ThreeSumProblem tp = new ThreeSumProblem();
       int result =  tp.threeSumClosest(nums,target);
       System.out.println("Three Sum problem:"+result);
    }

}
