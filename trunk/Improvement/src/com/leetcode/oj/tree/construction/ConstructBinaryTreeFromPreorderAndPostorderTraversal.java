package com.leetcode.oj.tree.construction;

import java.util.HashMap;

import com.leetcode.oj.common.model.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 */

// OK
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal 
{
	// O(N)
	public TreeNode buildTree(int[] inorder, int[] postorder) 
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		build_index(inorder, map);
		return buildTree_rec(inorder, postorder, 0, 0, inorder.length, map);
    }
	
	public void build_index(int[] inorder, HashMap<Integer, Integer> map)
	{
		for (int i = 0; i < inorder.length; i++)
		{
			map.put(inorder[i], i);
		}
	}
	
	public TreeNode buildTree_rec(int[] inorder, int[] postorder, int in_start, int post_start, int size, HashMap<Integer, Integer> map)
	{
		if (size <= 0)
			return null;
		int rootVal = postorder[post_start+size-1];
		TreeNode root = new TreeNode(rootVal);
		int index = map.get(rootVal);
		int left_tree_size = index - in_start;
		int right_tree_size = in_start + size - 1 - index;
		root.left = buildTree_rec(inorder, postorder, in_start, post_start, left_tree_size, map);
		root.right = buildTree_rec(inorder, postorder, in_start+left_tree_size+1, post_start+left_tree_size, right_tree_size, map);
		return root;
	}
}
