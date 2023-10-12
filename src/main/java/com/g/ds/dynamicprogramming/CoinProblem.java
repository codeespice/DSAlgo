package com.g.ds.dynamicprogramming;

import java.util.Arrays;

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
    public int smartVersionofCoins(int[] coins,int amount){

        /*
                dp[0]    dp[1]	    dp[2]	dp[3]	dp[4]
            j=1	    0	    1	    2	    3	    4
            j=2		        1	    1	    2	    2
            j=3
         */
        if(coins.length==0 || amount ==0){
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);//fill all the array with amount+1
        dp[0]=0; //dp[0]=0 -> base condition since for 0 we dont need any more coins

        for(int i=0;i<coins.length;i++){      //iterate through the coins that we use i.e for each coin calculate the dp since we use the current coin it will be always less coins
            for(int j=coins[i];j<=amount;j++){  //you can iterate by yourself using coing 1,2,5  and  j=coin()i.e 1,2,5 for answer it would be easy to understand
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1); //  this goes through multiple iterations and keep updating
                                                           // the values like seen above table in the comment
                                                          // value is min of already existing value (@j)  or the value at  valid coin used (j-validcoin(1 or 2 or 5) (in this case (1,2,5) + current coin
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];

    }

    public static void main(String[] args){
        CoinProblem cp = new CoinProblem();
        int[] coins = {1,2,5};
        int sum =11;
       int count =  cp.numberofCoins(sum);

       int count2 = cp.smartVersionofCoins(coins,sum);
       System.out.println("count:"+count2);
    }
}
