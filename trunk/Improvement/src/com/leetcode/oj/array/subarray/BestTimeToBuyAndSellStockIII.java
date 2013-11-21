package com.leetcode.oj.array.subarray;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i. 
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

// OK
public class BestTimeToBuyAndSellStockIII 
{
	// Other thoughts: calculate diffs, convert into m segments maximum subarray problem
	// O(N)
	public static int maxProfit(int[] prices) 
	{
		int[] max_ending_n = new int[prices.length];
		int[] max_starting_n = new int[prices.length+1];
		
		int min_index = 0;
		int max_profit = 0;
		for (int i = 0; i < prices.length; i++)
		{
			if (prices[i] < prices[min_index])
				min_index = i;
			if (prices[i] - prices[min_index] > max_profit)
				max_profit = prices[i] - prices[min_index];
			
			max_ending_n[i] = max_profit;
		}
		
		int max_index = prices.length-1;
		max_profit = 0;
		for (int i = prices.length-1; i >= 0; i--)
		{
			if (prices[i] > prices[max_index])
				max_index = i;
			if (prices[max_index] - prices[i] > max_profit)
				max_profit = prices[max_index] - prices[i];
			
			max_starting_n[i] = max_profit;
		}
		
		int ret = 0;
		for (int i = 0; i < prices.length; i++)
		{
			if (max_ending_n[i] + max_starting_n[i+1] > ret)
				ret = max_ending_n[i] + max_starting_n[i+1];
		}
		return ret;
    }
	
	public static void main (String[] args)
	{
		int[] A = new int[] {2,1,2,0,1};
		System.out.println(maxProfit(A));
	}
}
