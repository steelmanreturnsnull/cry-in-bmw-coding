package com.leetcode.oj.list;

import com.leetcode.oj.common.model.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 *
 */

public class SwapNodesInPairs 
{
	public ListNode swapPairs(ListNode head) 
	{
		if (head == null || head.next == null)
			return head;
		
		ListNode ret = head.next;
		ListNode prev;
		
		while (head !=null && head.next != null)
		{
			prev = head;
			head = head.next;
			prev.next = head.next;
			head.next = prev;
			head = prev.next;
		}
		return ret;
    }
}
