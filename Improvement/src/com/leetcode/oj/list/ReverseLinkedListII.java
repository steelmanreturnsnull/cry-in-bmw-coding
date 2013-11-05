package com.leetcode.oj.list;

import com.leetcode.oj.common.ListUtil;
import com.leetcode.oj.common.model.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 */

// OK
public class ReverseLinkedListII 
{
	// Idea: This worth re-writing 5 times:
	// preM: node before M, preM.next keeps tracking of head, which would finally be N
	// pre : node M, pre.next keeps tracking of head.next, which would finally be N.next
	// head.next = preM.next (which was head last iteration
	// O(N)
	public static ListNode reverseBetween(ListNode head, int m, int n) 
	{
		ListNode dummy = new ListNode(0);
	    dummy.next = head;

	    ListNode preM = null, pre = dummy;
	    for (int i = 1; i <= n; ++i) 
	    {
	    	if (i == m) preM = pre;

	    	if (i > m && i <= n) 
	    	{
	    		pre.next = head.next; 
	    		head.next = preM.next;
	    		preM.next = head;
	    		head = pre; //make sure that head gets set to head.next
	        }
    		pre = head;
	        head = head.next;
	    }
	    return dummy.next;
	}
	
	public static void main (String[] args)
	{
		reverseBetween(ListUtil.getCommonLists(4), 2, 4);
	}
}
