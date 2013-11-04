package com.leetcode.oj.tree.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

import com.leetcode.oj.common.TreeUtil;
import com.leetcode.oj.common.model.TreeNode;

/**
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
        
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 * 
 */

// OK
public class PathSumII {
	
	// O(N)
    public static boolean isLeaf(TreeNode root) 
    { 
		return (root !=null && root.left ==null && root.right ==null);
	}
    
    public static ArrayList<ArrayList<Integer>> pathSumRec (TreeNode root, int sum) 
    {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
    	pathSumRecHelper(root, sum, new ArrayList<Integer>(), result);
    	return result;
    }
    
    // Mistake: REUSING PATH OBJECT IS WRONG
    // Base case should behave same as general
    public static void pathSumRecHelper (TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) 
    {
    	if (root == null)
    		return;
    	if (isLeaf(root))
    	{
    		if (sum == root.val)
    		{
    			ArrayList<Integer> newPath = new ArrayList<Integer> (path); // NEED to create a new one here
    			newPath.add(root.val);
    			result.add(newPath);
    		}
    	}
    	else
    	{
    		ArrayList<Integer> newPath = new ArrayList<Integer> (path); 
    		newPath.add(root.val);
    		pathSumRecHelper (root.left, sum - root.val, newPath, result);
    		pathSumRecHelper (root.right, sum - root.val, newPath, result);
    	}
    }
    
    // Mistake: Order inverted, FIFO order, stack FILO
    public static ArrayList<ArrayList<Integer>> pathSum_Improved (TreeNode root, int sum) 
    {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
    	if (root == null)
			return result;
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
				{
					ArrayList<Integer> temp = new ArrayList<Integer> ();
					for (TreeNode node : stack)
					{
						temp.add(node.val);
					}
					Collections.reverse(temp);
					result.add(temp);
				}
				stack.pop();
				current_sum -= root.val;
			}
			prev = root;
		}
		return result;
    }
    
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) 
    {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
    	Stack<TreeNode> treeStack = new Stack<TreeNode> ();
    	Stack<Integer> partialSum = new Stack<Integer> ();
    	Stack<ArrayList<Integer>> partialPath = new Stack<ArrayList<Integer>> ();
    	if (root == null)
    		return result;
    	treeStack.add(root);
    	partialSum.add(root.val);
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(root.val);
		partialPath.add(path);
    	while (!treeStack.isEmpty()) 
    	{
    		TreeNode current = treeStack.pop();
    		int current_sum = partialSum.pop();
    		ArrayList<Integer> current_path = partialPath.pop();
    		if (isLeaf(current) && current_sum == sum)
    			result.add(current_path);
    		else 
    		{
    			if (current.left != null) 
    			{
    				treeStack.push(current.left);
    				partialSum.push(current_sum + current.left.val);
    				ArrayList<Integer> new_path = new ArrayList<Integer>(current_path);
    				new_path.add(current.left.val);
    				partialPath.push(new_path);
    			}
    			if (current.right != null) 
    			{
    				treeStack.push(current.right);
    				partialSum.push(current_sum + current.right.val);
    				ArrayList<Integer> new_path = new ArrayList<Integer>(current_path);
    				new_path.add(current.right.val);
    				partialPath.push(new_path);
    			}
    		}
    	}
    	return result;
    }

    public static void main(String[] args)
    {
    	pathSumRec(TreeUtil.getCommonTrees(5), 1);
    }
}
