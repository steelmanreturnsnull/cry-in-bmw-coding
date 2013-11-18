package com.leetcode.oj.tree.construction;

import com.leetcode.oj.common.model.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given

         1
        / \
       2   5
      / \   \
     3   4   6
     
 * The flattened tree should look like:
 * 
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
             
 * click to show hints.
 * 
 * Hints:
 * If you notice carefully in the flattened tree, 
 * each node's right child points to the next node of a pre-order traversal.
 */

// OK OK
public class FlattenBinaryTreeToLinkedList 
{
	// O(N) Solution (also return the tail of the flattened tree
	// O(N^2)
	public void flatten(TreeNode root) 
	{
		if (root == null)
			return;
		
		TreeNode left = root.left;
		TreeNode right= root.right;
		
		root.left = null;
		flatten(left);
		
		if (left != null)
		{
			TreeNode rightMost = left;
			while (rightMost.right != null)
			{
				rightMost = rightMost.right;
			}
			root.right = left;
			rightMost.right = right;
		}
		
		flatten(right);
    }
}
