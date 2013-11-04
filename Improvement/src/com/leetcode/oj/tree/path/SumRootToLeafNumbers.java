package com.leetcode.oj.tree.path;

import com.leetcode.oj.common.model.TreeNode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,

    1
   / \
  2   3
  
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 */

//OK
public class SumRootToLeafNumbers
{
	// O(N)
	public int sumNumbers(TreeNode root) 
	{
        return sum_rec(root, 0);
    }
	
	public static boolean isLeaf(TreeNode root) 
	{ 
		return (root !=null && root.left ==null && root.right ==null);
	}
	
	public int sum_rec (TreeNode root, int current_sum)
	{
		if (root == null)
			return 0;
		current_sum = current_sum * 10 + root.val;
		if (isLeaf(root))
			return current_sum;
		else
			return sum_rec(root.left, current_sum) + sum_rec(root.right, current_sum);
	}
}
