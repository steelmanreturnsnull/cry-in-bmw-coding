package com.leetcode.oj.maths.combinations;

import java.util.ArrayList;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 *  
 */

// OK
public class PermutationSequence 
{
	// O(N)
    public static String getPermutation(int n, int k) 
    {
    	k = k -1;
    	
    	ArrayList<Integer> unselected = new ArrayList<Integer>();
    	int factorial = 1;
    	for (int j = 1; j <= n; j++)
    	{
    		factorial *= j;
    		unselected.add(j);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	int i = 0;
    	while (i < n)
    	{
    		factorial = factorial / (n-i);
    		
    		int quotient  = k / factorial;
    		k = k % factorial;
    		
    		sb.append(unselected.get(quotient));
    		unselected.remove(quotient);
    		
    		i++;
    	}
    	return sb.toString();
    }
    
    public static void main (String[] args)
    {
    	getPermutation(1,1);
    	int n = 4;
    	for (int k=0; k<=23; k++)
    	{
    		System.out.println(getPermutation(n, k));
    	}
    }
}
