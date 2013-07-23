package leetcode.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import common.TreeNode;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
 * return [1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */
public class BinaryTreeInorderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode root) 
	{
		if (root == null)
			return new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer> ();
		ArrayList<Integer> left = inorderTraversal(root.left);
		list.addAll(left);
		list.add(root.val);
		ArrayList<Integer> right = inorderTraversal(root.right);
		list.addAll(right);
		return list;
    }
	
	public ArrayList<Integer> inorderTraversalIter(TreeNode root) 
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Set<TreeNode> isVisited = new HashSet<TreeNode>();
		if (root != null)
		{
			stack.push(root);
			isVisited.add(root);
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (!stack.isEmpty())
		{
			TreeNode iter = stack.peek();
			if (iter.left !=null && !isVisited.contains(iter.left))
			{
				stack.push(iter.left);
				isVisited.add(iter.left);
				continue;
			}
			if (iter.right !=null && !isVisited.contains(iter.right))
			{
				stack.push(iter.right);
				isVisited.add(iter.right);
				continue;
			}
			result.add(iter.val);
			stack.pop();
		}
		return result;
	}
}
