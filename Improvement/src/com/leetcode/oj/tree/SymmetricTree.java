package com.leetcode.oj.tree;

import java.util.LinkedList;

import com.leetcode.oj.common.TreeUtil;
import com.leetcode.oj.common.model.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

 *
 * But the following is not:

    1
   / \
  2   2
   \   \
   3    3
   
 *
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */

// OK
public class SymmetricTree 
{
	// O(N)
    public static boolean isSymmetric(TreeNode root) 
    {
    	if (root == null) return true;
    	return isSymmetric(root.left, root.right);
    }
    
    public static boolean isSymmetric(TreeNode left, TreeNode right)
    {
    	if (left == null && right == null) return true;
    	if (left == null || right == null) return false;
    	if (left.val != right.val) return false;
    	return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
    
    // Use two iterators, do symmetric iteration, result must be same
    public static boolean isSymmetricIter(TreeNode root) 
    {
    	if (root == null) return true;
    	LinkedList<TreeNode> leftStack = new LinkedList<TreeNode> ();
    	LinkedList<TreeNode> rightStack = new LinkedList<TreeNode> ();
    	
    	leftStack.push(root.left);
    	rightStack.push(root.right);
    	while (!leftStack.isEmpty() && !rightStack.isEmpty())
    	{
    		TreeNode iterLeft = leftStack.pop();
    		TreeNode iterRight = rightStack.pop();
    		
        	if (iterLeft == null && iterRight == null) continue;
        	if (iterLeft == null || iterRight == null || iterLeft.val != iterRight.val) return false;
    		
    		leftStack.add(iterLeft.left);
    		leftStack.add(iterLeft.right);
    		rightStack.add(iterRight.right);
    		rightStack.add(iterRight.left);    		
    	}
    	if (leftStack.isEmpty() && rightStack.isEmpty())
    		return true;
    	return false;
    }
    
    public static void main (String[] args)
    {
    	for (int i = 0; i < 10; i++)
    	{
    		System.out.print(isSymmetricIter(TreeUtil.getCommonTrees(i)));
    		System.out.println(isSymmetric(TreeUtil.getCommonTrees(i)));
    	}
    }
}
