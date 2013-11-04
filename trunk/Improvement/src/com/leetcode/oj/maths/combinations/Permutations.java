package com.leetcode.oj.maths.combinations;

import java.util.ArrayList;

import com.leetcode.oj.common.PrintUtil;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

// OK
public class Permutations 
{
	// O(N!)
	public static ArrayList<ArrayList<Integer>> permute(int[] num) 
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> selected = new ArrayList<Integer> ();
		ArrayList<Integer> unselected = new ArrayList<Integer> ();
		for (int i : num)
		{
			unselected.add(i);
		}
		permute_rec(selected, unselected, result);
		
		return result;
    }
	
	public static void permute_rec (ArrayList<Integer> selected, ArrayList<Integer> unselected, ArrayList<ArrayList<Integer>> result)
	{
		if (unselected.isEmpty())
		{
			result.add(selected);
		}
		else
		{
			for (int index = 0; index < unselected.size(); index++)
			{
				ArrayList<Integer> next_selected = new ArrayList<Integer> (selected);
				next_selected.add(unselected.get(index));
				
				ArrayList<Integer> next_unselected = new ArrayList<Integer> (unselected);
				next_unselected.remove(index);
				
				permute_rec(next_selected, next_unselected, result);
			}
		}
	}
	
	public static void main (String[] args)
	{
		int array[] = new int[] {1, 3, 5, 7, 9};
		PrintUtil.print(permute(array));
	}
}
