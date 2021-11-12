package com.g.ds.dynamicprogramming;
/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2


Solution:
Input: coins = [1,2,5], amount = 11
f(n)  = f(n-1)+f(n-2)+f(n-5)
 */
public class CoinProblem {

    public int numberofCoins(int sum){
        int[] dp = new int[sum+1];
        dp[0]=0;//base case yse 0 coins to make 0 cents
        //fillup the rest of array
        for(int i=1;i<=sum;i++){
            dp[i] = dp[i-1]+1; // handle n-1 case

            if(i-2>0){//handle 2 coin i.e n-2
                dp[i] = Math.min(dp[i-2]+1,dp[i]);
            }
            if(i-5>0){//handle 5 coin i.e n-5
                dp[i] = Math.min(dp[i-5]+1,dp[i]);
            }
        }
        return dp[sum];
    }

    public static void main(String[] args){
        CoinProblem cp = new CoinProblem();
        int[] coins = {1,2,5};
        int sum =11;
       int count =  cp.numberofCoins(sum);
       System.out.println("count:"+count);
    }
}
