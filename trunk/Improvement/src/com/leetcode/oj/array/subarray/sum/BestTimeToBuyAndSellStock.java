package com.leetcode.oj.array.subarray.sum;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 */

// OK
public class BestTimeToBuyAndSellStock 
{
	// Other thoughts: can be solved in O(N) too by calculating delta each day, then solve a maximum subarray problem.
	// O(N)
	public int maxProfit(int[] prices) 
	{
		int min_index = 0;
		int max_profit = 0;
		for (int i = 0; i < prices.length; i++)
		{
			if (prices[i] < prices[min_index])
				min_index = i;
			if (prices[i] - prices[min_index] > max_profit)
				max_profit = prices[i] - prices[min_index];
		}
		return max_profit;
    }
}
