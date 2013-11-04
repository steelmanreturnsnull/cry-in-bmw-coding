package com.leetcode.oj.number.sum;

import java.util.HashMap;

import com.leetcode.oj.common.PrintUtil;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
 * are not zero-based.
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
*/

// OK
public class TwoSum 
{ 
	// O(1) space O(NlgN) solution:
	// Sort then use two pointers to iterate
	
	// O(N)
    public static int[] twoSum(int[] numbers, int target) 
    { 
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[] result = new int[2];
    	for (int i = 0; i < numbers.length; i++) 
    	{
    		if (map.containsKey(target - numbers[i])) 
    		{
    			result[0] = map.get(target - numbers[i]) + 1;
    			result[1] = i + 1;
    		}
    		else {
    			map.put(numbers[i], i);
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args)
    {
    	int a[] = new int[] {4, 22, 2, 4, 15};
    	PrintUtil.print(twoSum(a, 8));
    }
}
