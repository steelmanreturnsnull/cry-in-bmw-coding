package com.leetcode.oj.maths;

/**
 * Implement pow(x, n).
 *
 */

// OK
public class Pow 
{
	// O(lg(N)) <= 32
	public static double pow(double x, int n)
	{
 		long m  = Math.abs((long)n); // Note (Math.abs(INT_MIN) == INT_MIN -- overflow, so we need to use long)
		double ret = 1;
		for (; m != 0 ; x *= x, m >>= 1)
		{
			if ((m & 1) != 0)
				ret *= x; 
		}
		return (n>0) ? ret : (1.0/ret);
	}
	
	public static void main (String[] args)
	{
		System.out.println(pow(8.02, Integer.MIN_VALUE));
	}
	
//    Time complexity - O(N)
//    public double pow(double x, int n) 
//    {
//    	double result = 1;
//    	if (n == 0)
//    		return result;
//   		for (int i = 1; i <=n ; i++)
//		{
//			result = result * x;
//		}
//   		if (n > 0)
//   			return result;
//   		if (x != 0)
//   			return -result;
//   		else
//   			return 0;
//    }
}

