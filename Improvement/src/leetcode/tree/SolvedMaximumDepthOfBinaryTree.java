package leetcode.tree;

import common.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 */

public class SolvedMaximumDepthOfBinaryTree 
{
    public int maxDepth(TreeNode root) 
    {
    	if (root == null)
    		return 0;
    	return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
