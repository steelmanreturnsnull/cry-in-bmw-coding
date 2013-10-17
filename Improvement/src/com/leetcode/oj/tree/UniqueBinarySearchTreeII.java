package com.leetcode.oj.tree;

import java.util.ArrayList;

import com.leetcode.oj.common.TreeNode;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * 
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 */

// Need to add null (otherwise won't be looped)

// OK
public class UniqueBinarySearchTreeII 
{
	// O(Cn)
	public static ArrayList<TreeNode> generateTrees(int n) 
	{
		return generateTrees_rec(1, n);
    }
	
	public static ArrayList<TreeNode> generateTrees_rec(int begin, int end)
	{
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();

		if (begin > end)
		{
			result.add(null);
			return result;
		}
		
		ArrayList<TreeNode> lefts = null;
		ArrayList<TreeNode> rights = null;
		for (int i = begin; i <= end; i++)
		{
			lefts = generateTrees_rec(begin, i-1);
			rights = generateTrees_rec(i+1, end);
			
			for (TreeNode left: lefts)
			{
				for (TreeNode right: rights)
				{
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					
					result.add(root);
				}
			}
		}
		return result;
	}
	
	@SuppressWarnings("unused")
	public static void main (String[] args)
	{
		ArrayList<TreeNode> list = generateTrees(3);
	}
}
