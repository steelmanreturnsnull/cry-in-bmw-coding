package com.leetcode.oj.array;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 */

// OK
public class RemoveElement 
{
	// Other thoughts: 
	// O(N)
	public int removeElement(int[] A, int elem) 
	{
		int size = A.length;
		int swap_id = size-1;
		for (int i = 0; i < size;)
		{
			if (A[i] == elem)
			{
				A[i] = A[swap_id--];
				size--;
			}
			else
				i++; //increment id only when not swapped
		}
		return size;
    }
}
