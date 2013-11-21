package com.leetcode.oj.list;

import com.leetcode.oj.common.ListUtil;
import com.leetcode.oj.common.PrintUtil;
import com.leetcode.oj.common.model.ListNode;

/**
 * Reverse a linked list. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL,
 * 
 * return 5->4->3->2->1->NULL.
 * 
 */

// OK
public class ReverseLinkedList 
{
	// O(N)
	public static ListNode reverse(ListNode head) 
	{
		if (head == null)
			return null;
		
		ListNode prev = null;
		
		while (head != null)
		{
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	public static void main (String[] args)
	{
		PrintUtil.print(reverse(ListUtil.getCommonLists(4)));
	}
}
