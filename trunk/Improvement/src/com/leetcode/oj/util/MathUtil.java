package com.leetcode.oj.util;

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
}
