package com.leetcode.oj.maths.combinations;

import java.util.ArrayList;
import java.util.Arrays;

import com.leetcode.oj.common.PrintUtil;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * 
 * 
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 *
 */

// OK
public class Subsets 
{
	// O(2^N)
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) 
	{
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>()); // NOTE: BASE CASE
		
		for (int element : S)
		{
			int size = result.size();
			for (int i = 0; i < size; i++)
			{
				ArrayList<Integer> temp = new ArrayList<Integer> (result.get(i));
				temp.add(element);
				result.add(temp);
			}
		}
		return result;
    }
	
	// Alternative solution
	// Use N-bit bit array, if that bit is 1, add that number to result
	
	// Alternative solution 2
	// dfs + recursion
	
	public static void main (String[] args)
	{
		int a[] = new int[] {3, 5, 1, 9};
		PrintUtil.print(subsets(a));
	}
}
