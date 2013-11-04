package com.leetcode.oj.array;

/** 
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * 
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3]. 
 * 
 */

// OK
public class RemoveDuplicatesFromSortedArrayII 
{
	// O(N)
	 public int removeDuplicates(int[] A) 
	 {
		 if (A.length <= 2)
			 return A.length;
		 int i = 0;
		 boolean once = false;
		 for (int j = 1; j < A.length; j++)
		 {
			 if (A[j]!=A[i])
			 {
				 A[++i] = A[j]; 
				 once = false;
			 }
			 else if (!once)
			 {
				 A[++i] = A[j];
				 once = true;
			 }
		 }
		 return i+1;
	 }
}
