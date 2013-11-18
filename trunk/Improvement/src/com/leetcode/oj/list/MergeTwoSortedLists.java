package com.leetcode.oj.list;

import com.leetcode.oj.common.model.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 */

// OK OK
public class MergeTwoSortedLists 
{
	// O(m+n)
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
	{
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		
		while (l1!=null && l2!=null)
		{
			ListNode next;
			if (l1.val > l2.val)
			{
				next = l2;
				l2 = l2.next;
			}
			else 
			{
				next = l1;
				l1 = l1.next;
			}
			
			current.next = next;
			current = next;
		}		
		
		if (l1 == null) current.next = l2;
		if (l2 == null) current.next = l1;
		
//		while (l1!=null || l2!=null)
//		{
//			ListNode next;
//			if (l1 == null || l1!=null && l2!=null && l1.val > l2.val)
//			{
//				next = l2;
//				l2 = l2.next;
//			}
//			else 
//			{
//				next = l1;
//				l1 = l1.next;
//			}
//			
//			current.next = next;
//			current = next;
//		}
		
		return dummy.next;
    }
}
