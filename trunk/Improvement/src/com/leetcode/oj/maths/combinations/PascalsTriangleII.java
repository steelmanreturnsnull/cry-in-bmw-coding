package com.leetcode.oj.maths.combinations;

import java.util.ArrayList;

import com.leetcode.oj.common.PrintUtil;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space? *
 */

// OK
public class PascalsTriangleII 
{
	// O(N^2)
    public static ArrayList<Integer> getRow(int rowIndex) 
    {
    	ArrayList<Integer> result = new ArrayList<Integer> ();
    	
    	for (int i = 0; i <= rowIndex; i++) 
    	{
    		result.add(0);
    	}
    	result.set(0, new Integer(1));
    	
    	for (int i = 1; i <= rowIndex; i++)
    	{
    		for (int j = i; j >= 1; j--)
    		{
    			if (j == i)
    				result.set(j, new Integer(1));
    			else
    				result.set(j, new Integer(result.get(j).intValue() + result.get(j-1).intValue()));
    		}
    	}
    	return result;
    }
    
    public static void main (String[] args)
    {
    	PrintUtil.print(getRow(5));
    }
}
