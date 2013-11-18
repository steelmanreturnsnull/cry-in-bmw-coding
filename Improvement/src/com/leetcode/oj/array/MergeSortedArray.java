package com.leetcode.oj.array;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note:
 * You may assume that A has enough space to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * 
 */

public class MergeSortedArray 
{
	 public void merge(int A[], int m, int B[], int n) 
	 {
		 m = m - 1;
		 n = n - 1;
		 int c = m + n - 1;
		 while (c>0)
		 {
			 if (m>=0 && A[m] > B[n])
				 A[c--] = A[m--];
			 else
				 A[c--] = B[n--];
		 }
     }
}
