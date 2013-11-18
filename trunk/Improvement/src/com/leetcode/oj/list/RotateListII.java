package com.leetcode.oj.list;

import com.leetcode.oj.common.ListUtil;
import com.leetcode.oj.common.PrintUtil;
import com.leetcode.oj.common.model.ListNode;

/**
 * Given a list, rotate the list to the left by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 3->4->5->1->2->NULL.
 * 
 */

// OK
public class RotateListII 
{
	// O(N)
	public static ListNode rotateLeft(ListNode head, int n)
	{
		if (n==0 || head==null)
    		return head;
		
		int size = 1;
		ListNode iter = head;
        while (iter.next != null)
        {
        	iter = iter.next;
        	size ++;
        }
        
        int rotate = n % size;
        iter.next = head;
        
        while (rotate!=0)
        {
        	iter = iter.next;
        	rotate --;
        }
        
        head = iter.next;
        iter.next = null;
        return head;
		
	}
	
	public static void main (String[] args)
	{
		PrintUtil.print(rotateLeft(ListUtil.getCommonLists(4), 2));
	}
}
