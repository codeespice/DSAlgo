package com.g.ds.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.



        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Output: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]

 */
public class TwoSumProblem {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int compliment=0;
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            compliment = target-nums[i];
            if(map.containsKey(compliment) && map.get(compliment) != i ){
                result[0]=i;
                result[1]= map.get(compliment);
                return result;
            }
        }
        return result;

    }
    /*
    Another version where you just need to check if two numbers with sum exist
     */
    public boolean twoSumExists(int[] nums, int target) {

        Arrays.sort(nums);

        int lo=0;
        int high = nums.length-1;
        boolean flag=false;

        while(lo<high){

            if(nums[lo]+nums[high]==target){
                flag = true;
               break;

            }
            else if(nums[lo]+nums[high]<target){
                lo =lo+1;
            }
            else{
                high =high-1;
            }
        }

        return flag;
    }
    /*
    Another version with sorted elements
     */
    public int[] twoSumSorted(int[] nums, int target) {


        int[] result = new int[2];
        int lo=0;
        int high = nums.length-1;


        while(lo<high){

            if(nums[lo]+nums[high]==target){
                result[0] =lo;
                result[1] =high;
                break;

            }
            else if(nums[lo]+nums[high]<target){
                lo =lo+1;
            }
            else{
                high =high-1;
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = {2,11,7,15};
        int target = 9;
        TwoSumProblem ts = new TwoSumProblem();
       int[] result = ts.twoSum(nums,target);
        System.out.println("Un SortedResult");
       Arrays.stream(result).forEach(x->System.out.println(x));
        boolean flag = ts.twoSumExists(nums,target);
        System.out.println("two Sum Exist : "+flag);
        int[] sortedNums = {2,7,11,15};
        int[] sortedResult = ts.twoSumSorted(sortedNums,target);
        System.out.println("SortedResult");
        Arrays.stream(sortedResult).forEach(x->System.out.println(x));
    }
}
