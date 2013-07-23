package leetcode;

import java.util.Stack;

import common.TreeNode;



/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class PathSum {

	
    public boolean isLeaf(TreeNode root) { 
		return (root !=null && root.left ==null && root.right ==null);
	}
    
    public boolean hasPathSum(TreeNode root, int sum) {
    	Stack<TreeNode> treeStack = new Stack<TreeNode> ();
    	Stack<Integer> partialSum = new Stack<Integer> ();
    	if (root == null)
    		return false;
    	treeStack.add(root);
    	partialSum.add(root.val);
    	while (!treeStack.isEmpty()) {
    		TreeNode current = treeStack.pop();
    		int current_sum = partialSum.pop();
    		if (isLeaf(current) && current_sum == sum)
    			return true;
    		else {
    			if (current.left != null) {
    				treeStack.push(current.left);
    				partialSum.push(current_sum + current.left.val);
    			}
    			if (current.right != null) {
    				treeStack.push(current.right);
    				partialSum.push(current_sum + current.right.val);
    			}
    		}
    	}
    	return false;
    }
}
