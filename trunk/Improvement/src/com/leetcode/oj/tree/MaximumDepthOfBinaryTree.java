package com.leetcode.oj.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.oj.common.TreeUtil;
import com.leetcode.oj.common.model.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

// Mistake: Can't use in-order, as root is visited before right child

// OK
public class MaximumDepthOfBinaryTree 
{
	// O(N)
	// DFS (Post-order)
	public static int maxDepth_improved(TreeNode root) 
	{
		int height = 0;
		if (root == null)
			return height;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		TreeNode prev = null;
		while (!stack.isEmpty())
		{
			root = stack.peek();
			if (prev == null || prev.left == root || prev.right == root) //First Time
			{
				if (root.left != null)
				{
					stack.push(root.left);
				}
				else if (root.right != null)
				{
					stack.push(root.right);
				}
			}
			else if (root.left == prev) //Second Time
			{
				if (root.right != null)
					stack.push(root.right);
			}
			else //Third Time
			{
				if (stack.size() > height)
					height = stack.size();
				stack.pop();
			}
			prev = root;
		}
		return height;
	}
	
	// BFS
    public static int maxDepth(TreeNode root) 
    {
    	int max = -1;
    	Queue<TreeNode> treeQueue = new LinkedList<TreeNode> ();
    	Queue<Integer> heightQueue = new LinkedList<Integer> ();
    	if (root == null)
    		return 0;
    	treeQueue.add(root);
    	heightQueue.add(1);
    	while (!treeQueue.isEmpty()) 
    	{
    		TreeNode current = treeQueue.remove();
    		int height = heightQueue.remove();
    		if (isLeaf(current) && height > max)
    			max = height;
    		else 
    		{
    			if (current.left != null) 
    			{
    				treeQueue.add(current.left);
    				heightQueue.add(height+1);
    			}
    			if (current.right != null) 
    			{
    				treeQueue.add(current.right);
    				heightQueue.add(height+1);
    			}
    		}
    	}
    	return max;
    }
    
	public static boolean isLeaf(TreeNode root) 
	{ 
		return (root !=null && root.left ==null && root.right ==null);
	}
    
    public static int maxDepthRec(TreeNode root) 
    {
    	if (root == null)
    		return 0;
    	return Math.max(maxDepthRec(root.left) + 1, maxDepthRec(root.right) + 1);
    }
    
    public static void main (String[] args)
    {
    	TreeNode tree = TreeUtil.getCommonTrees(4);
    	System.out.println(maxDepth_improved(tree));
    }
}
