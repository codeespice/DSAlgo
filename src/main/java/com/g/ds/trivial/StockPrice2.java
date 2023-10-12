package com.g.ds.trivial;
/*
Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 */
public class StockPrice2 {

    public int maxProfit(int[] prices) {
        int totalProfit=0;

        for(int i=0;i<prices.length-1;i++){

            if(prices[i+1] >prices[i]){
                totalProfit = totalProfit+prices[i+1]-prices[i];
            }
        }
        return totalProfit;
    }

    public static void main(String[] args){
        StockPrice2 sp2 = new StockPrice2();
        int[] prices = {7,1,5,3,6,4};
        int[] prices2 = {1,2,3,4,5};
        int maxProfit = sp2.maxProfit(prices2);
        System.out.println("MaxProfit: "+maxProfit);
    }
}
