package com.leetcode.oj.tree;

import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtil;

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
    
    public static void main (String[] args)
    {
    	System.out.println(isSameTree(TreeUtil.getCommonTrees(5), TreeUtil.getCommonTrees(5)));
    }
}
