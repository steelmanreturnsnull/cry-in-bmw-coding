package com.leetcode.oj.tree.construction;

import java.util.HashMap;

import com.leetcode.oj.common.model.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 */

// OK
public class ConstructBinaryTreeFromInorderAndPostorderTraversal 
{
	// O(N)
	public TreeNode buildTree(int[] preorder, int[] inorder) 
	{
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		build_index(inorder, map);
		return buildTree_rec(preorder, inorder, 0, 0, preorder.length, map);
    }
	
	public void build_index(int[] inorder, HashMap<Integer, Integer> map)
	{
		for (int i = 0; i < inorder.length; i++)
		{
			map.put(inorder[i], i);
		}
	}
	
	public TreeNode buildTree_rec(int[] preorder, int[] inorder, int pre_start, int in_start, int size, HashMap<Integer, Integer> map)
	{
		if (size <= 0)
			return null;
		int rootVal = preorder[pre_start];
		TreeNode root = new TreeNode(rootVal);
		int index = map.get(rootVal);
		int left_tree_size = index - in_start;
		int right_tree_size = in_start + size - 1 - index;
		root.left = buildTree_rec(preorder, inorder, pre_start+1, in_start, left_tree_size, map);
		root.right = buildTree_rec(preorder, inorder, pre_start+1+left_tree_size, in_start+left_tree_size+1, right_tree_size, map);
		return root;
	}
}
