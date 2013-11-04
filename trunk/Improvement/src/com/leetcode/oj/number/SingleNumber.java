package com.leetcode.oj.number;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 */

//OK
public class SingleNumber 
{
	// O(N)
    public static int singleNumber(int[] A) 
    {
    	int result = 0;
    	for (int a: A)
    	{
    		result ^= a;
    	}
    	return result;
    }
    
    public static void main (String[] args)
	{
    	int[] A = {1, 5, 7, 8, 9, 5, 7, 1, 9};
		System.out.println(singleNumber(A));
	}
}
