package com.leetcode.oj.maths.combinations;

import java.util.ArrayList;

import com.leetcode.oj.util.PrintUtil;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * Return
 * 
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 *
 */

// OK
public class PascalsTriangle 
{
	// O(N^2)
	public static ArrayList<ArrayList<Integer>> generate(int numRows) 
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		
		if (numRows < 1)
			return result;
		
		ArrayList<Integer> temp = new ArrayList<Integer> ();
		temp.add(1);
		result.add(temp);
		
		for (int i = 2; i <= numRows; i++)
		{
			temp = new ArrayList<Integer> ();
			for (int j = 0; j < i; j++)
			{
				int num;
				if (j ==0 || j == (i-1))
					num = 1;
				else
					num = result.get(i-2).get(j-1) + result.get(i-2).get(j);
				temp.add(num);
			}
			result.add(temp);
		}
		
		return result;
    }
	
	public static void main (String[] args)
	{
		PrintUtil.print(generate(5));
	}
}
