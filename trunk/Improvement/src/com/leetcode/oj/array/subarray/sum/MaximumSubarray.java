package com.leetcode.oj.array.subarray.sum;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * click to show more practice.
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, 
 * which is more subtle. *
 */

public class MaximumSubarray 
{
	// O(N)
    public static int maxSubArray(int[] A)
    {
    	if (A == null || A.length == 0)
    		return 0;
    	int max_so_far = A[0];
    	int max_ending_here = A[0];
    	
    	for (int i = 1; i < A.length; i++)
    	{
    		if (max_ending_here < 0)
    			max_ending_here = A[i];
    		else
    			max_ending_here += A[i];
    		
    		if (max_ending_here > max_so_far)
    			max_so_far = max_ending_here;
    	}
    	
    	return max_so_far;
    }
    
    public static void main (String[] args)
    {
    	int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    	System.out.println(maxSubArray(array));
    }
}
