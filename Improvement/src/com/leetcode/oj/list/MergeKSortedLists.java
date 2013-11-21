package com.leetcode.oj.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.leetcode.oj.common.model.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. 
 * Analyze and describe its complexity.
 */

// OK
public class MergeKSortedLists 
{
	// Improvement: use a PQ
	// O(knlogk)
	public static ListNode mergeKLists_improved(ArrayList<ListNode> lists)
	{
    	if (lists==null || lists.size() == 0)
    		return null;
    	
    	Comparator<ListNode> comp = new Comparator<ListNode>() 
		{
			@Override
			public int compare(ListNode o1, ListNode o2) 
			{
				return o1.val - o2.val;
			}
		};
		
		PriorityQueue<ListNode> pq  = new PriorityQueue<ListNode>(lists.size(), comp);
		for (ListNode n: lists)
		{
			if (n!=null)
				pq.add(n);
		}
		
		ListNode dummy = new ListNode(0);
    	ListNode current = dummy;
    	while (!pq.isEmpty())
    	{
    		ListNode min = pq.poll();
    		current.next = min;
    		current = current.next;
    		if (min.next!=null)
    			pq.add(min.next);
    	}
    	
    	return dummy.next;
	}
	
	// Mistake: Object in a List is a reference!
	// O(k^2n)
    public static ListNode mergeKLists(ArrayList<ListNode> lists) 
    {
    	if (lists==null || lists.size() == 0)
    		return null;
    	
    	ArrayList<ListNode> ptrs = new ArrayList<ListNode> ();
    	for (ListNode node : lists)
    	{
    		ptrs.add(node);
    	}
    	
    	ListNode dummy = new ListNode(0);
    	ListNode current = dummy;
    	
    	while (!isAllNull(ptrs))
    	{
    		ListNode min = findMin(ptrs);
    		current.next = min;
    		current = current.next;
    		ptrs.remove(min);
    		ptrs.add(min.next);
    	}
    	
    	return dummy.next;
    }
    
    private static boolean isAllNull (ArrayList<ListNode> lists)
    {
    	for (ListNode node : lists)
    	{
    		if (node!=null)
    			return false;
    	}
    	return true;
    }
    
    private static ListNode findMin (ArrayList<ListNode> lists)
    {
    	ListNode min = null;
    	for (ListNode node : lists)
    	{
    		if (min == null)
    			min = node;
    		else if (node != null && node.val < min.val)
    			min = node;
    	}
    	return min;
    }

    public static void main (String[] args)
    {
    	ArrayList<ListNode> array = new ArrayList<ListNode> ();
    	array.add(new ListNode(1));
    	mergeKLists(array);
    }
}
