package leetcode.list;

import common.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 < m < n < length of list.
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		
		// find m - 1
		ListNode iter = head;
		while (m!=2)
		{
			iter = iter.next;
			m--;
			n--;
		}
		ListNode fixHead = iter;
		iter = iter.next;
		ListNode fixHeadNext = iter;
		while (n>0)
		{
			ListNode thisOne = iter;
			ListNode nextOne = iter.next;
			nextOne.next = thisOne;
			
		}
		// find n
		
		return head;
    }
	
	public static ListNode reverseTwo (ListNode head) 
	{
		ListNode temp = head.next.next;
		head.next.next = head;
		return null;
	}
}
