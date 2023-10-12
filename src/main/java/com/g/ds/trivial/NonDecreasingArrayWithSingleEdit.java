package com.g.ds.trivial;

import java.util.Arrays;
/*
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
This problem seems easy at first read. If we iterate through the nums array (N), count the number of instances in which an element is lower than the one preceeding (err), and then see that count go above 1, then we should be able to return false. The problem becomes more difficult, however, once we realize that we're allowed to modify one element, which will naturally impact its relationship with the surrounding elements.

[4,2,3] -> here when we point to 4 and compare with 3 . we can decrease 4 to 2 or increase 2 to 4 to match the condition greater or equal to
either way has no issue because we don't need any more edits to make it non decreasing array

consider the scenario
[3,4,2,3] -> here compare 4 and 2 you have chance to decrease 4 to 2 or increase 2 to 4 but you have to consider carefully

if you want to make 2 to 4 , compare the right  of 2 then it will be  [3,4,4,3] -> which is not non decreasing array
so you have to consider i-2 and i=1 elements change 4 to 2 it will be [3,2,2,3] -> which is non decreasing array so we have to return false

 [5,4,6,8] -> here you can make 4 to 6 or 6 to 4  to do that you have to consider 5 and 8  if you make 6 to 4  then [5,4,4,8] -> non decreasing array
 so you have to compare 6>=5 and then change 4<=8 so you have to change 4 to 6 [5,6,6,8]-> non decreasing array
 */
public class NonDecreasingArrayWithSingleEdit {
    public static boolean canBeNonDecreasing(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true; // An empty array or an array with one element is always non-decreasing.
        }

        int count = 0; // Count of edits needed to make the array non-decreasing.

        for (int i = 1; i < nums.length && count <= 1; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (i >= 2 && nums[i] < nums[i - 2]) { //eg [5,6,4,8]
                    nums[i] = nums[i - 1]; // Try replacing nums[i].
                } else {
                    nums[i - 1] = nums[i]; // Try replacing nums[i - 1]. eg [5,4,6,8]
                }
            }
        }

        return count <= 1; // If count is at most 1, it can be made non-decreasing with a single edit.
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, 3}; // This can be made non-decreasing with a single edit (change 4 to 1).
        int[] arr2 = {4, 2, 1}; // This cannot be made non-decreasing with a single edit.
        int[] arr3 = {5,4,6, 8}; // This can be made non-decreasing with a single edit.
        int[] arr4 = {5,4,3, 8}; // This cannot be made non-decreasing with a single edit.
        int[] arr5 = {5,6,4, 8}; // This can be made non-decreasing with a single edit.


        Arrays.stream(arr1).forEach(x->System.out.print(x+","));
        System.out.println("  arr1 can be made non-decreasing with a single edit: " + canBeNonDecreasing(arr1));
        Arrays.stream(arr2).forEach(x->System.out.print(x+","));
        System.out.println("  arr2 can be made non-decreasing with a single edit: " + canBeNonDecreasing(arr2));
    }
}
