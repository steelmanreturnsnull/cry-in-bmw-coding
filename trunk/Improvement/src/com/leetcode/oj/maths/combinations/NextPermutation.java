package com.leetcode.oj.maths.combinations;

import com.leetcode.oj.common.ArraysUtil;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

/*
 * From wikipedia
 * 
 * The following algorithm generates the next permutation lexicographically after a given permutation. It changes the given permutation in-place.
 * Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
 * Find the largest index l such that a[k] < a[l].
 * Swap the value of a[k] with that of a[l].
 * Reverse the sequence from a[k + 1] up to and including the final element a[n].
 */

// OK
public class NextPermutation 
{
	// O(N)
	public void nextPermutation(int[] num) 
	{
		int k = -1;
		for (int i = 0; i < num.length-1 ; i++)
		{
			if (num[i] < num[i+1])
				k = i;
		}
		if (k == -1)
		{
			ArraysUtil.reverse(num);
			return;
		}
				
		int l = -1;
		for (int i = 0; i < num.length; i++)
		{
			if (num[k] < num[i])
				l = i;
		}
		
		ArraysUtil.swap(num, k, l);
		
		ArraysUtil.reverse(num, k+1, num.length-1);
    }
}
