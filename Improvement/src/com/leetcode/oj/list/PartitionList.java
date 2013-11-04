package com.leetcode.oj.list;

import com.leetcode.oj.common.model.ListNode;

/**
 * Given a linked list and a value x, 
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 */

// OK
public class PartitionList 
{
	// O(N)
	public static ListNode partition_improved(ListNode head, int x)
	{
		ListNode first = new ListNode(0);
		ListNode second = new ListNode(0);
		ListNode p1 = first;
		ListNode p2 = second;
		while (head != null)
		{
			if (head.val < x)
			{
				p1.next = head;
				p1 = head;
			}
			else
			{
				p2.next = head;
				p2 = head;
			}
			head = head.next;
		}
		p1.next = second.next;
		p2.next = null; //Set to null
		return first.next;
	}
	
    public static ListNode partition(ListNode head, int x) 
    {
    	ListNode firstPartHead = null;
    	ListNode firstPartTail = null;
    	ListNode secondPartHead = null;
    	ListNode secondPartTail = null;
    	
    	while (head != null)
    	{
    		if (head.val < x)
    		{
    			if (firstPartHead == null)
    			{
    				firstPartHead = head;
    				firstPartTail = head;
    			}
    			else
    			{
    				firstPartTail.next = head;
    				firstPartTail = head;
    			}
    		}
    		else
    		{
    			if (secondPartHead == null)
    			{
    				secondPartHead = head;
    				secondPartTail = head;
    			}
    			else
    			{
    				secondPartTail.next = head;
    				secondPartTail = head;
    			}
    		}
    		head = head.next;
    	}
    	
    	if (firstPartTail == null)
    		return secondPartHead;
    	
    	firstPartTail.next = secondPartHead;
    	if (secondPartTail != null)
    		secondPartTail.next = null;
    	return firstPartHead;
    }
    
    public static void main (String[] args)
    {
    	ListNode one = new ListNode(1);
    	ListNode two = new ListNode(2);
    	two.next = one;
    	partition_improved(two, 2);
    }
}
