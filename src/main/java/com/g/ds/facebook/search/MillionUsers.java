package com.g.ds.facebook.search;

import java.util.HashMap;
import java.util.Map;

/*
We have N different apps with different user growth rates. At a given time t, measured in days, the number of users using an app is g^t (for simplicity we'll allow fractional users), where g is the growth rate for that app. These apps will all be launched at the same time and no user ever uses more than one of the apps. We want to know how many total users there are when you add together the number of users from each app.
After how many full days will we have 1 billion total users across the N apps?
Signature
int getBillionUsersDay(float[] growthRates)
Input
1.0 < growthRate < 2.0 for all growth rates
1 <= N <= 1,000
Output
Return the number of full days it will take before we have a total of 1 billion users across all N apps.
Example 1
growthRates = [1.5]
output = 52
Example 2
growthRates = [1.1, 1.2, 1.3]
output = 79
Example 3
growthRates = [1.01, 1.02]
output = 1047
 */
/*
Answer : Binary search on number of days i.e take initially int MAX and try to reduce the number of days as much as possible
until the total number of users fall below 1 billion , the last count that was there would be the answer
 */
public class MillionUsers {
    int billion = 1000000000;
    Map<Integer,Integer> countUserDays = new HashMap<>();
    public boolean growthRateHelper(int mid, float[] growthRates)
    {
        double totalUsers = 0;
        for(int i = 0 ; i < growthRates.length; i++)
        {
            totalUsers +=  Math.pow(growthRates[i], mid);
        }


        return (int)totalUsers >= billion;
    }
    int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        int low = 1, high = Integer.MAX_VALUE;

        while(low < high)
        {
            int mid = low + (high-low)/2;
            if(growthRateHelper(mid,growthRates))
            {
                high = mid;
            }else{
                low = mid+1;
            }
        }

        return low;

    }
    public static void main(String args[]){
        MillionUsers millionUsers = new MillionUsers();
        float[] growthRates = {1.5f};
       int days=  millionUsers.getBillionUsersDay(growthRates);
       System.out.println(String.format("days=%s",days));
    }
}
