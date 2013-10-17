package leetcode.list;

import com.leetcode.oj.common.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 */

public class PartitionList 
{
    public static ListNode partition(ListNode head, int x) 
    {
    	ListNode firstPartHead = null;
    	ListNode firstPartTail = null;
    	ListNode secondPartHead = null;
    	ListNode secondPartTail = null;
    	
    	ListNode iter = head;
    	while (iter != null)
    	{
    		if (iter.val < x)
    		{
    			if (firstPartHead == null)
    			{
    				firstPartHead = iter;
    				firstPartTail = iter;
    			}
    			else
    			{
    				firstPartTail.next = iter;
    				firstPartTail = iter;
    			}
    		}
    		else
    		{
    			if (secondPartHead == null)
    			{
    				secondPartHead = iter;
    				secondPartTail = iter;
    			}
    			else
    			{
    				secondPartTail.next = iter;
    				secondPartTail = iter;
    			}
    		}
    		iter = iter.next;
    	}
    	
    	if (firstPartTail == null)
    		return secondPartHead;
    	
    	firstPartTail.next = secondPartHead;
    	return firstPartHead;
    }
    
    public static void main (String[] args)
    {
    	ListNode one = new ListNode(1);
    	ListNode two = new ListNode(2);
    	two.next = one;
    	partition(two, 2);
    }
}
