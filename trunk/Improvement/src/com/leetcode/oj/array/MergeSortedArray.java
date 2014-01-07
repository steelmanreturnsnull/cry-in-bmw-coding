package com.leetcode.oj.array;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note:
 * You may assume that A has enough space to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * 
 */

// OK
public class MergeSortedArray 
{
	// O(m+n)
	// A little better: store in A, so we only need to move every B into A
	public void merge(int A[], int m, int B[], int n) 
	{
		 while (n > 0)
		 {
			 if (m > 0 && A[m-1] > B[n-1])
				 A[m + n - 1] = A[--m];
			 else
				 A[m + n - 1] = B[--n];
		 }
    }
	 
/*	 public void merge(int A[], int m, int B[], int n) 
	 {
		 m = m - 1;
		 n = n - 1;
		 int c = m + n - 1;
		 while (c > 0)
		 {
			 if (m >= 0 && A[m] > B[n])
				 A[c--] = A[m--];
			 else
				 A[c--] = B[n--];
		 }
     }*/
}
