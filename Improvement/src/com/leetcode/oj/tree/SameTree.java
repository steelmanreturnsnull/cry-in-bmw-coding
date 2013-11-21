package com.leetcode.oj.tree;

import java.util.LinkedList;

import com.leetcode.oj.common.TreeUtil;
import com.leetcode.oj.common.model.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */

// OK
public class SameTree 
{
	// O(N)
    public static boolean isSameTree(TreeNode p, TreeNode q) 
    {
        if (p == null && q == null)
        	return true;
        if (p == null || q == null)
        	return false;
        if (p.val != q.val)
        	return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    
    // Mistakes: the three if statements must have else
    public static boolean isSameTreeIter(TreeNode p, TreeNode q)
    {
    	LinkedList<TreeNode> stackP = new LinkedList<TreeNode>();
    	LinkedList<TreeNode> stackQ = new LinkedList<TreeNode>();
		while (!stackP.isEmpty() || p != null || !stackQ.isEmpty() || q != null)
		{
			if (p == null && q == null)
			{
				p = stackP.pop();
				q = stackQ.pop();
				if (p.val != q.val)
					return false;
				p = p.right;
				q = q.right;
			}
			else if (p != null && q != null)
			{
				stackP.push(p);
				stackQ.push(q);
				p = p.left;
				q = q.left;
			}
			else
			{
				return false;
			}
		}
		return true;
    }
    
    public static void main (String[] args)
    {
    	System.out.println(isSameTreeIter(TreeUtil.getCommonTrees(2), TreeUtil.getCommonTrees(2)));
    }
}
