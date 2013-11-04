package com.leetcode.oj.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.oj.common.model.TreeNode;

// OK
public class MinimumDepthOfBinaryTree {
	
	// O(N)
    public static boolean isLeaf(TreeNode root) 
    { 
		return (root !=null && root.left ==null && root.right ==null);
	}
    
    public static int minDepthRec (TreeNode root)
    {
    	if (root == null)
    		return 0;
    	return minDepthRecHelper(root, 0);
    }
    
    public static int minDepthRecHelper (TreeNode root, int depth)
    {
    	if (root == null)
    		return Integer.MAX_VALUE;
    	if (isLeaf(root))
    		return depth+1;
    	else
    		return Math.min(minDepthRecHelper(root.left, depth+1), minDepthRecHelper(root.right, depth+1));
    }
    
    // BFS, first leaf we find is the depth
    public static int minDepth(TreeNode root) 
    {
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
    		if (isLeaf(current))
    			return height;
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
    	return -1;
    }
}
