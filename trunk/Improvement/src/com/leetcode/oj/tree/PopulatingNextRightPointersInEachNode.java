package com.leetcode.oj.tree;

import java.util.ArrayList;

import com.leetcode.oj.common.TreeLinkNode;

/**
 * Given a binary tree
 * 
 *  Populate each next pointer to point to its next right node. 
 *  If there is no next right node, the next pointer should be set to NULL.
 *  
 *  Initially, all next pointers are set to NULL.
 *  
 *  Note:
 *  
 *  You may only use constant extra space.
 *  You may assume that it is a perfect binary tree 
 *  (ie, all leaves are at the same level, and every parent has two children).
 *  
 *  For example,
 *  Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
 * After calling your function, the tree should look like:
 * 
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 */

// OK
public class PopulatingNextRightPointersInEachNode 
{
	// O(N)
	public void connect_improved(TreeLinkNode root)
	{
		if (root == null) 
			return;
		if (root.left != null)
			root.left.next = root.right;
		if (root.right != null)
			root.right.next = (root.next == null) ? null : root.next.left;
		connect (root.left);
		connect (root.right);
	}
	
	// Uses extra space
	public void connect(TreeLinkNode root) 
	{
		ArrayList<TreeLinkNode> currentQueue = new ArrayList<TreeLinkNode> ();
    	ArrayList<TreeLinkNode> nextQueue = new ArrayList<TreeLinkNode> ();
        if (root != null)
        	currentQueue.add(root);
        while (!currentQueue.isEmpty())
        {
        	nextQueue = new ArrayList<TreeLinkNode> ();
        	for (TreeLinkNode t : currentQueue)
        	{
        		if (t.left != null)
        			nextQueue.add(t.left);
        		if (t.right != null)
        			nextQueue.add(t.right);
        	}
        	int i = 0;
        	for (; i < currentQueue.size()-1; i++)
        	{
        		currentQueue.get(i).next = currentQueue.get(i+1);
        	}
        	currentQueue.get(i).next = null;
        	currentQueue = nextQueue;
        }
    }
}
