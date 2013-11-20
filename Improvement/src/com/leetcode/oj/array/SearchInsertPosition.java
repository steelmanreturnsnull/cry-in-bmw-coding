package com.leetcode.oj.array;

/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */

public class SearchInsertPosition 
{
	public int searchInsert(int[] A, int target) 
	{
		int L = 0;
		int R = A.length -1;
		while (L <= R)
		{
			if (target <= A[L])
				return L;
			if (target > A[R])
				return R+1;
			int M = L + (R-L)/2;
			if (target == A[M])
				return M;
			else if (target < A[M])
				R = M - 1;
			else
				L = M + 1;
		}
		return -1;
    }
}
