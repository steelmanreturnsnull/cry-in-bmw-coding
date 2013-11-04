package com.leetcode.oj.tree;

import com.leetcode.oj.common.TreeUtil;
import com.leetcode.oj.common.model.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined 
 * as a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1.
 *
 */

// Mistake: Add one to calculate height

public class BalancedBinaryTree 
{
	// O(N)
	// Other thoughts: use -1 to indicate not balance in height
	public static boolean isBalanced_Improved(TreeNode root) 
	{
 		return isBalancedHelper_Improved(root) >= 0;
    }
	
	public static int isBalancedHelper_Improved(TreeNode root)
	{
		if (root == null)
		{
			return 0;
		}
		else
		{
			int leftC = isBalancedHelper_Improved(root.left);
			int rightC = isBalancedHelper_Improved(root.right);
			return (rightC < 0 || leftC < 0 || Math.abs(leftC-rightC) >1 ) ? -1 : Math.max(leftC, rightC) +1 ;
		}
	}
	
	private static class Compact
	{
		private boolean isBalanced;
		private int height;
		
		private Compact(boolean isBalanced, int height)
		{
			this.isBalanced = isBalanced;
			this.height = height;
		}
	}
	
	public static boolean isBalanced(TreeNode root) 
	{
 		return isBalancedHelper(root).isBalanced;
    }
	
	public static  Compact isBalancedHelper(TreeNode root)
	{
		if (root == null)
		{
			return new Compact(true, 0);
		}
		else
		{
			Compact leftCompact = isBalancedHelper(root.left);
			Compact rightCompact = isBalancedHelper(root.right);
			int height = Math.max(leftCompact.height, rightCompact.height) + 1;
			boolean isBalaneced = (Math.abs(leftCompact.height - rightCompact.height) <= 1 ) && leftCompact.isBalanced && rightCompact.isBalanced;
			return new Compact(isBalaneced, height);
		}
	}
	
	public static void main (String[] args)
	{
		isBalanced(TreeUtil.getCommonTrees(3));
	}
}
