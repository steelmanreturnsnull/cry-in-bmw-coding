package com.leetcode.oj.tree.construction;

import com.leetcode.oj.common.ListUtil;
import com.leetcode.oj.common.model.ListNode;
import com.leetcode.oj.common.model.TreeNode;

// OK OK
public class ConvertSortedListToBinarySearchTree 
{
	// O(N)
    public static TreeNode sortedListToBST(ListNode head) 
    {
        int len = 0;
        ListNode it = head;
        while(it != null)
        {
        	it = it.next;
            len ++;
        }
        return sortedListToBSTHelper(head, 0, len-1);
    }
    
    public static TreeNode sortedListToBSTHelper(ListNode head, int begin, int end)
    {
        if(begin > end) return null;
        int mid = begin + (end - begin) / 2;
        
        // KEY: need to do left first, it will swap head with mid
        // Every node created will move head 1 step ahead
        // So in the end it will move size(left) steps which is mid
        TreeNode left = sortedListToBSTHelper(head, begin, mid-1); 
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        
        if(head.next != null)
        {
            head.val = head.next.val;
            head.next = head.next.next;
        }
        
        root.right = sortedListToBSTHelper(head, mid+1, end);
        
        return root;
    }
    
    public static void main (String[] args)
    {
    	sortedListToBST(ListUtil.getCommonLists(3));
    }
}
