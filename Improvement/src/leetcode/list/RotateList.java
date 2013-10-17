package leetcode.list;

import com.leetcode.oj.common.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 *
 */

// Mistake: Didn't save new tail, and change iter.next to null first. (then when you try to find the tail, if fails...)
// Mistake2: Read the question! wrong rotate direction
// Mistake3: size = 1, size - n%size == size

public class RotateList {
	
	public static ListNode rotateRight(ListNode head, int n) {
		
    	if (n==0 || head==null)
    		return head;
		
		ListNode iter = head;
        int rotates = 0;
        while (iter.next != null)
        {
        	iter = iter.next;
        	rotates ++;
        }
        int size = rotates + 1;
        
        if (size == 1)
        	return head;
        
        return rotateLeft(head, size - n%size);
		
	}
	
    public static ListNode rotateLeft(ListNode head, int n) {
    	
    	if (n==0 || head==null)
    		return head;
    	
        ListNode newHead = null;
        
        ListNode iter = head;
        int rotates = 0;
        while (iter.next != null && rotates + 1 < n)
        {
        	iter = iter.next;
        	rotates ++;
        }
        
        if (iter.next == null) 
        {
        	return rotateLeft(head, n%(rotates+1));
        }
        else 
        {
        	newHead = iter.next;
        	ListNode newTail = iter;
        	
        	while (iter.next != null)
            {
            	iter = iter.next;
            }
        	
        	iter.next = head;
        	newTail.next = null;
        	return newHead;
        }
    }
    
    public static void main (String[] args)
    {
    	ListNode one = new ListNode(1);
    	ListNode two = new ListNode(2);
    	one.next = two;
    	rotateRight(one,2);
    }
}
