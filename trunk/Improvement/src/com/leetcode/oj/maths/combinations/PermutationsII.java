package com.leetcode.oj.maths.combinations;

import java.util.ArrayList;
import java.util.Arrays;

import com.leetcode.oj.common.PrintUtil;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */

// OK
public class PermutationsII 
{
	// O(N!)
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) 
	{
		Arrays.sort(num);
		
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
				if (index != 0 && unselected.get(index) == unselected.get(index-1))
					continue;
					
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
		int array[] = new int[] {1, 3, 3};
		PrintUtil.print(permuteUnique(array));
	}
}
