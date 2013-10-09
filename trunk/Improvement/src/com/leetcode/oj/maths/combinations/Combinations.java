package com.leetcode.oj.maths.combinations;

import java.util.ArrayList;

import com.leetcode.oj.util.PrintUtil;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

// OK
public class Combinations 
{
	// O(C(n,k))
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) 
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer> ();
		
		combine_rec(result, temp, n, k, 1);
		return result;
    }
	
	public static void combine_rec(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int n, int k, int index)
	{
		if (k==0)
		{
			ArrayList<Integer> list = new ArrayList<Integer> (temp); // NOTICE HERE!
			result.add(list);
		}
		else if (index <= n)
		{
			temp.add(index);
			combine_rec(result, temp, n, k-1, index+1);
			
			temp.remove(temp.size()-1);
			combine_rec(result, temp, n, k, index+1);
		}
	}
	
	public static void main (String[] args)
	{
		PrintUtil.print(combine(5,3));
	}
}
