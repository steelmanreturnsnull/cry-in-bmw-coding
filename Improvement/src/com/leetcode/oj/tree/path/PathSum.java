package com.leetcode.oj.tree.path;

import java.util.LinkedList;
import java.util.Stack;

import com.leetcode.oj.common.model.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 *
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 */

// OK
public class PathSum 
{
	
	// O(N)
	private boolean isLeaf(TreeNode root)
	{
		return (root != null && root.left==null && root.right==null);
	}
	
    public boolean hasPathSum(TreeNode root, int sum) 
    {
    	if (root == null)
    		return false;
    	if (isLeaf(root))
    		return (root.val == sum);
    	return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    
    public boolean hasPathSumIter_Improved (TreeNode root, int sum) 
    {
    	if (root == null)
			return false;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		int current_sum = 0;
		stack.push(root);
		current_sum += root.val;
		TreeNode prev = null;
		while (!stack.isEmpty())
		{
			root = stack.peek();
			if (prev == null || prev.left == root || prev.right == root) //First Time
			{
				if (root.left != null)
				{
					stack.push(root.left);
					current_sum += root.left.val;
				}
				else if (root.right != null)
				{
					stack.push(root.right);
					current_sum += root.right.val;
				}
			}
			else if (root.left == prev) //Second Time
			{
				if (root.right != null)
				{
					stack.push(root.right);
					current_sum += root.right.val;
				}
			}
			else //Third Time
			{
				if (isLeaf(root) && current_sum == sum)
					return true;
				stack.pop();
				current_sum -= root.val;
			}
			prev = root;
		}
		return false;
    }
    
    public boolean hasPathSumIter(TreeNode root, int sum) 
    {
    	Stack<TreeNode> treeStack = new Stack<TreeNode> ();
    	Stack<Integer> partialSum = new Stack<Integer> ();
    	if (root == null)
    		return false;
    	treeStack.add(root);
    	partialSum.add(root.val);
    	while (!treeStack.isEmpty()) 
    	{
    		TreeNode current = treeStack.pop();
    		int current_sum = partialSum.pop();
    		if (isLeaf(current) && current_sum == sum)
    			return true;
    		else 
    		{
    			if (current.left != null) 
    			{
    				treeStack.push(current.left);
    				partialSum.push(current_sum + current.left.val);
    			}
    			if (current.right != null) 
    			{
    				treeStack.push(current.right);
    				partialSum.push(current_sum + current.right.val);
    			}
    		}
    	}
    	return false;
    }
}