package com.leetcode.oj.common;

public class MathUtil 
{
	public static int factorial (int n)
	{
		if (n <= 1)
			return 1;
		int result = 1;
		for (int i = 2; i <= n; i++)
		{
			result *= i;
		}
		return result;
	}
	
	public static int[][] TwoByTwoMatrixMultiply (int[][] a, int[][] b)
	{
		int[][] r = new int[2][2];
		r[0][0] = a[0][0] * b[0][0] + a[0][1] * b[1][0];
		r[0][1] = a[0][0] * b[0][1] + a[0][1] * b[1][1];
		r[1][0] = a[1][0] * b[0][0] + a[1][1] * b[1][0];
		r[1][1] = a[1][0] * b[0][1] + a[1][1] * b[1][1];
		return r;
	}
}
