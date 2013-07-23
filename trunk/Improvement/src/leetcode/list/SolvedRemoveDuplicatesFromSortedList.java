package leetcode.list;

import common.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */

public class SolvedRemoveDuplicatesFromSortedList 
{
	public static ListNode deleteDuplicates(ListNode head) 
	{
		ListNode first = head;
		ListNode second = head;
		while (first != null)
		{
			second = second.next;
			if (second == null || second.val != first.val)
			{
				first.next = second;
				first = second;
			}
		}
		return head;
    }

}
