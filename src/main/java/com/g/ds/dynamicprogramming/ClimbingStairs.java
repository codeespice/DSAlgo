package com.g.ds.dynamicprogramming;
/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
solution :
f(n) = f(n-1)+1 + fn(n-2)+2
i.e calculate for n-1 steps and add 1
calculate for n-2 steps and add 2
terminal conditions are f(1)=1 f(2)=1
 */
public class ClimbingStairs {
//climb stairs recursive top down approach
    public int climbStairs(int n){
        int[] memo = new int[n+1];
        memo[0]=1;
        memo[1]=1;
        return recurse(n,memo);
    }
    private int recurse(int n,int[] memo){

        if(memo[n]>0){
            return memo[n];
        }
        int result= recurse(n-1,memo)+recurse(n-2,memo);
        memo[n] =result;
        return result;
    }
    //iterative bottom up approach
    public int climbStairsIterative(int n){
        int[] memo = new int[n+1];
        memo[0]=1;
        memo[1]=1;
       for(int i=2;i<=n;i++){
           memo[i] = memo[i-2]+memo[i-1];
       }
       return memo[n];
    }
    public static void main(String[] args){
        ClimbingStairs cs = new ClimbingStairs();
        int result = cs.climbStairs(5);
        System.out.println("result:"+result);
        System.out.println("result Iterative:"+cs.climbStairsIterative(5));
    }
}
