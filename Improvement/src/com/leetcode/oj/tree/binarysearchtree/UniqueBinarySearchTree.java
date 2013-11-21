package com.leetcode.oj.tree.binarysearchtree;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 *
 */

// OK
public class UniqueBinarySearchTree 
{
	// Thoughts: C0 = 1, C1 = 1, C2 = C1 + C1 (以1为root和以2为root)
	// O(N)
    public static int numTrees(int n) 
    {
    	int[] C = new int[n+1];
    	C[0] = 1;
    	
    	for (int i = 1; i <= n; i++)
    	{
    		for (int j = 0; j <= i-1; j++)
    		{
    			C[i] += C[j] * C[i-1-j];
    		}
    	}
    	return C[n];
    }
    
    // Mistakes: new int[n+1]
    
    public static void main(String[] args)
    {
    	for (int i = 0; i < 10; i++)
    	{
    		System.out.println(numTrees(i));
    	}
    }
}
