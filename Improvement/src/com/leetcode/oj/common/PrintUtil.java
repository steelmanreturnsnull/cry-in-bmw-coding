package com.leetcode.oj.common;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.leetcode.oj.common.model.ListNode;

public class PrintUtil
{
	private static PrintStream out = System.out;
	
	public static void main (String[] args)
	{
		int a[] = new int[] {1, 2, 4};
		print(a);
		println();
		
		List<Integer> b = new ArrayList<Integer>();
		b.add(5);
		b.add(34);
		print(b);
		println();
		
		List<List<Integer>> c = new ArrayList<List<Integer>>();
		c.add(b);
		c.add(b);
		print(c);
	}
	
	public static void println()
	{
		out.println();
	}
	
	public static void print(int[] array)
	{
		out.print("[");
		for (int i = 0; i < array.length; i++)
		{
			if (i != array.length-1)
				out.print(array[i] + ", ");
			else
				out.print(array[i] + "]");
		}
	}
	
	public static void print(List<?> array)
	{
		out.print("[");
		for (int i = 0; i < array.size(); i++)
		{
			if (i != array.size()-1)
				out.print(array.get(i) + ", ");
			else
				out.print(array.get(i) + "]");
		}
	}
	
	public static void print(ListNode head)
	{
		while (head!=null)
		{
			out.print(head.val);
			if (head.next != null)
				out.print("->");
			head = head.next;
		}
	}
}
