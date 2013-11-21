package com.leetcode.oj.array.subarray;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times). 
 * However, you may not engage in multiple transactions at the same time 
 * (ie, you must sell the stock before you buy again).
 */

// OK
public class BestTimeToBuyAndSellStockII 
{
	// O(N)
	int maxProfit(int[] prices) 
	{
        int max_profit = 0;
        for(int i = 1; i < prices.length ; i++) 
        {
            int delta = prices[i] - prices[i-1];
            if (delta > 0) 
            {
            	max_profit += delta;
            }
        }
        return max_profit;
    }
	
/*	
 * public int maxProfit(int[] prices) 
	{
		int max_profit = 0;
		int local_min_index = -1;
		int local_max_index = -1;
		
		for (int i = 1; i < prices.length; i++)
		{
			if (prices[i-1] < prices[i]) // buy if not bought
			{
				if (local_min_index == -1)
				{
					local_min_index = i - 1;
				}
				local_max_index = i;
			}
			
			if (prices[i-1] > prices[i]) // sell if not sold
			{
				if (local_max_index != -1)
					max_profit += prices[local_max_index] - prices[local_min_index];
				local_min_index = -1;
				local_max_index = -1;
			}
		}
		if (local_max_index != -1)
			max_profit += prices[local_max_index] - prices[local_min_index];
		return max_profit;
    }
 */
}
