package com.leetcode.oj.tree.construction;

import com.leetcode.oj.common.model.TreeNode;

/**
 * Convert Sorted Array to Binary Search Tree AC Rate: 1555/4653 My Submissions
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 */

// OK
public class ConvertSortedArrayToBinarySearchTree 
{
	// O(N)
	public TreeNode sortedArrayToBST(int[] num) 
	{
		return sortedArrayToBST (num, 0, num.length-1);
    }
	
	public TreeNode sortedArrayToBST(int[] num, int begin, int end)
	{
		if (begin > end)
			return null;
		int mid = begin + (end - begin) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, begin, mid -1);
		root.right = sortedArrayToBST(num, mid+1, end);
		return root;
	}
}
