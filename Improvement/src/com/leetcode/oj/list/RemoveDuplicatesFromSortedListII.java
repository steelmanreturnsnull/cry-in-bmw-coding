package com.leetcode.oj.list;

import com.leetcode.oj.common.model.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *
 */

// OK
public class RemoveDuplicatesFromSortedListII 
{
	// O(N)
	// Nice solution! Solve problem recursively.
	public static ListNode deleteDuplicates_rec (ListNode head)
	{
		if (head == null || head.next == null)
			return head;
		ListNode p = head.next;
		if (head.val == p.val)
		{
			while (p!=null && p.val == head.val) // Notice the logic here, try to write again
			{
				p = p.next;
			}
			return deleteDuplicates_rec (p);
		}
		head.next = deleteDuplicates_rec (head.next);
		return head;
	}
	
	// Mistake1: you need to have a head and tail for the new list... (only have unique... and update unique.next every time is wrong)
	// Mistake2: using uniqueTail, didn't set uniqueTail.next = null
	public static ListNode deleteDuplicates(ListNode head) 
	{
		ListNode first = head;
		ListNode second = head;
		
		ListNode uniqueHead = null;
		ListNode uniqueTail = null;
		
		while (first != null)
		{
			second = second.next;
			if (second == null || second.val != first.val)
			{
				if (second == first.next)
				{
					if (uniqueHead == null)
					{
						uniqueHead = first;
						uniqueTail = first;
					}
					else
					{
						uniqueTail.next = first;
						uniqueTail = first;
					}
				}
				first = second;
			}
		}
		if (uniqueTail != null)
			uniqueTail.next = null;
		return uniqueHead;
    }
	
	public static void main (String[] args)
    {
    	ListNode one = new ListNode(1);
    	ListNode two = new ListNode(1);
    	ListNode three = new ListNode(1);
    	one.next = two;
    	two.next = three;
    	deleteDuplicates(one);
    }
}
