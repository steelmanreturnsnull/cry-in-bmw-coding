package com.leetcode.oj.others;

import com.leetcode.oj.common.MathUtil;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 */

// OK
public class ClimbingStairs 
{
	// O(N)
	public int climbStairs(int n) 
	{
        int temp1 = 1, temp2 = 2;
        if (n <= 0)
        	return 0;
        if (n == 1)
        	return 1;
        if (n == 2)
        	return 2;
        for (int i = 3; i <= n; i++)
        {
        	int temp = temp1 + temp2;
        	temp1 = temp2;
        	temp2 = temp;
        }
        
        return temp2;
    }
	
	// Mistake: initial condition is different!
	// O(lgN)
	public int climbStairs_faster(int n)
	{
		return powerI(n+1)[1][0];
	}
	
	public static int[][] powerI (int n)
	{
		int[][] I = new int[2][2];
		I[0][0] = I[1][0] = I[0][1] = 1;
		I[1][1] = 0;
		if (n == 1)
			return I;
		
		int[][] i = MathUtil.TwoByTwoMatrixMultiply(powerI(n/2), powerI(n/2));
		if (n % 2 == 1)
		{
			return MathUtil.TwoByTwoMatrixMultiply(i, I);
		}
		else
			return i;
	}
	
	@SuppressWarnings("unused")
	public static void main (String[] args)
	{
		int i[][] = powerI(8);
	}
}
