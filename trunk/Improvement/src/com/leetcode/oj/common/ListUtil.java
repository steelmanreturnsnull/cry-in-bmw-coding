package com.leetcode.oj.common;

import com.leetcode.oj.common.model.ListNode;

public class ListUtil 
{
	private static String[] split (String s)
	{
		String trim = s.substring(1, s.length()-1);
		return trim.split(",");
	}
	
	public static ListNode constructListNode(String s) 
	{
		String[] parts = split(s);
		ListNode root = null;
		
		if (!parts[0].isEmpty())
		{
			root = new ListNode(Integer.valueOf(parts[0]));
		}
		ListNode iter = root;
		
		for (int i = 1; i < parts.length; i++)
		{
			ListNode next = new ListNode(Integer.valueOf(parts[i]));
			iter.next = next;
			iter = next;
		}
		return root;
	}
	
	public static ListNode getCommonLists (int id)
	{
		switch (id)
		{
			case 0:
				return constructListNode("{}");
			case 1:
				return constructListNode("{1}");
			case 2:
				return constructListNode("{1,2}");
			case 3:
				return constructListNode("{1,2,3}");
			case 4:
				return constructListNode("{1,2,3,4,5,6}");
			case 5:
				return constructListNode("{1,2,3,3,4,4,5}");
			case 6:
				return constructListNode("{0,0,0,0,0}");
			case 7:
				return constructListNode("{-3,-1,-1,0,0,0,0,0,2}");
			case 8:
				return constructListNode("{0,3,4}");
			case 9:
				return constructListNode("{0,0,0,0,3,4}");
			default:
				return constructListNode("{1,1,1,1}");
		}
	}
	
	@SuppressWarnings("unused")
	public static void main (String[] args) 
	{
		for (int i = 0; i < 10; i++)
		{
			ListNode a = getCommonLists(i);
		}
	}
}
