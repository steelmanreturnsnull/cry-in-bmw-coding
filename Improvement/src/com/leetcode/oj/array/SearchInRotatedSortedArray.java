package com.leetcode.oj.array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 */

public class SearchInRotatedSortedArray 
{
    public static int search(int[] A, int target) 
    {
    	return search(A, target, 0, A.length-1);
    }
    
    public static int search(int[] A, int target, int begin, int end) 
    {
    	if (begin > end)
    		return -1;
    	int mid = begin + (end - begin) / 2;
    	if (A[mid] == target)
    		return mid;
    	
    	if (A[begin] <= A[mid]) // Note the equal here
    	{
    		if (target < A[mid] && target >= A[begin])  // Note the equal here
    			return search(A, target, begin, mid-1);
    		else
    			return search(A, target, mid+1, end);
    	}
    	else
    	{
    		if (target > A[mid] && target <= A[end])  // Note the equal here
    			return search(A, target, mid+1, end);
    		else
    			return search(A, target, begin, mid-1);
    	}
    }
    
    public static void main (String[] args)
    {
    	int[] A = {3, 1};
    	System.out.println(search(A, 1));
    }
}
