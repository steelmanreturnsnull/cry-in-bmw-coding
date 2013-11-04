package com.leetcode.oj.tree.binarysearchtree;

import java.util.ArrayList;

import com.leetcode.oj.common.model.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 */

// OK
public class ValidateBinarySearchTree 
{
	// O(N)
    public boolean isValidBST(TreeNode root) 
    {
    	return isValidBST(root, null, null);
    }
    
    public boolean isValidBST(TreeNode root, Integer lower, Integer upper)
    {
    	if (root == null)
    		return true;
    	else
    	{
    		if (lower != null && root.val <= lower.intValue())
    			return false;
    		if (upper != null && root.val >= upper.intValue())
    			return false;
    		return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    	}
    }
    
    // Alternative solution: inorder traversal
    public boolean isValidBST2(TreeNode root) 
    {
    	ArrayList<Integer> list = inorderTraversal2(root);
    	for (int i = 0; i<list.size()-1; i++)
    	{
    		if (list.get(i) >= list.get(i+1))
    			return false;
    	}
    	return true;
    }
    
    public static ArrayList<Integer> inorderTraversal2(TreeNode root) 
	{
			
		ArrayList<Integer> list = new ArrayList<Integer> ();
		inorderTraversal_Improved(root, list);
		return list;
    }
	
	public static void inorderTraversal_Improved(TreeNode root, ArrayList<Integer> list) 
	{
		
		if (root == null)
			return;
		inorderTraversal_Improved(root.left, list);
		list.add(root.val);
		inorderTraversal_Improved(root.right, list);
    }
}
