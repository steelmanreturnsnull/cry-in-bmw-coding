package com.leetcode.oj.common;

public class ArraysUtil
{
	public static void swap (int[] array, int index1, int index2)
	{
		if (index1 < 0 || index1 >= array.length)
			return;
		if (index2 < 0 || index2 >= array.length)
			return;
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static void reverse(int[] array, int startIndex, int endIndex)
	{
		if (startIndex < 0 || startIndex >= array.length)
			return;
		if (endIndex < 0 || endIndex >= array.length)
			return;
		while (startIndex < endIndex)
		{
			swap (array, startIndex, endIndex);
			startIndex++;
			endIndex--;
		}
	}
	
	public static void reverse(int[] array)
	{
		if (array.length > 0)
			reverse(array, 0, array.length-1);
	}
}
