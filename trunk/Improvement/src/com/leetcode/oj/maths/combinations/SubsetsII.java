package com.leetcode.oj.maths.combinations;

import java.util.ArrayList;
import java.util.Arrays;

import com.leetcode.oj.util.PrintUtil;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * 
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If S = [1,2,2], a solution is:
 * 
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */

// OK
public class SubsetsII 
{
	// O(2^N)
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) 
	{
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		int dup;
		for (int index = 0; index < S.length; index = index + dup)
		{
			// first count duplicate elements
			dup = 1;
			while (index + dup < S.length && S[index] == S[index + dup])
				dup++;
			
			int size = result.size();
			for (int j = 1; j <= dup; j++)
			{
				for (int i = 0; i < size; i++)
				{
					ArrayList<Integer> temp = new ArrayList<Integer> (result.get(i));
					for (int k = 1; k <= j; k++) //Note: care index
						temp.add(S[index]);
					result.add(temp);
				}
			}
		}
		return result;
    }
	
	// Alternative solution
	// dfs + recursive: save level same number add once
	
	public static void main (String[] args)
	{
		int a[] = new int[] {2, 3, 1};
		PrintUtil.print(subsetsWithDup(a));
	}
}
