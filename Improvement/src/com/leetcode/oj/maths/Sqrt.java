package com.leetcode.oj.maths;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 *
 */

// OK
public class Sqrt 
{
	// O(lg(N))
    public static int sqrt(int x) 
    {
    	if (x <= 1) 
    		return x;
        int left = 0;
    	int right = x;
    	while (right >= left)
    	{
    		int mid = left + (right - left) / 2;  // Avoid overflow
    		int div = x / mid; // mid*mid may overflow
    		if (mid == div)
    			return mid;
    		else if (mid > div)
    			right = mid - 1;
    		else 
    			left = mid + 1;
    	}
    	return right;
    }
    
    public static void main (String[] args)
    {
    	System.out.println(sqrt(Integer.MAX_VALUE));
    }
}
