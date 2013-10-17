package com.leetcode.oj.numbers;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 */

//OK
public class SingleNumberII 
{
	//O(N)
    public static void main (String[] args)
	{
    	int[] A = {1, 5, 7, 8, 9, 5, 7, 1, 9, 1, 5, 7, 9};
		System.out.println(singleNumber(A));
	}
    
    public static int singleNumber(int[] A) 
    {
        int result = 0;
        int[] bits = new int[32];
        for (int a : A)
        {
        	for (int i = 0; i <32 ; i++)
        	{
        		bits[i] += (a >> i) & 1;
        	}
        }
        
    	for (int i = 0; i <32 ; i++)
    	{
    		bits[i] = bits[i] % 3;
    	}
        
    	for (int i = 0; i <32 ; i++)
    	{
    		result += bits[i] << i;
    	}
        
        return result;
        
    }
}
