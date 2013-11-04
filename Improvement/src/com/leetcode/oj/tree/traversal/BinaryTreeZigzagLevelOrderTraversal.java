package com.leetcode.oj.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;

import com.leetcode.oj.common.TreeUtil;
import com.leetcode.oj.common.model.TreeNode;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 *
 */

// OK
// Mistakes: must use two queues/stacks
public class BinaryTreeZigzagLevelOrderTraversal 
{
	// O(N)
	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) 
    {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
    	LinkedList<TreeNode> currentQueue = new LinkedList<TreeNode> ();
    	LinkedList<TreeNode> nextQueue = new LinkedList<TreeNode> ();
    	ArrayList<Integer> res = new ArrayList<Integer> ();
    	boolean reverse = false;
        if (root != null)
        	currentQueue.add(root);
        while (!currentQueue.isEmpty())
        {
        	TreeNode t = currentQueue.pop();
        	res.add(t.val);
        	
        	if (reverse)
        	{
        		if (t.right != null)
        			nextQueue.push(t.right);
        		if (t.left != null)
        			nextQueue.push(t.left);
        	}
        	else 
        	{
        		if (t.left != null)
        			nextQueue.push(t.left);
        		if (t.right != null)
        			nextQueue.push(t.right);
        	}
        	
        	if (currentQueue.isEmpty())
        	{
        		result.add(res);
        		currentQueue = nextQueue;
        		res = new ArrayList<Integer> ();
            	nextQueue = new LinkedList<TreeNode> ();
        		reverse = !reverse;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) 
	{
		for (int i=4; i<=4; i++)
		{
			TreeNode test = TreeUtil.constructFullTreeNode(i);
			System.out.println(zigzagLevelOrder(test));
		}
	}
}
