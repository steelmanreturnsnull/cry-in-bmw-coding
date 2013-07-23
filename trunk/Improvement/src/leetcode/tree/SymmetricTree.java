package leetcode.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import common.TreeNode;

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
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) 
    {
    	if (root == null) return true;
    	return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right)
    {
    	if (left == null && right == null) return true;
    	if (left == null || right == null) return false;
    	if (left.val != right.val) return false;
    	return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
    
    public boolean isSymmetricIter(TreeNode root) 
    {
    	if (root == null) return true;
    	if (root.left == null && root.right ==null) return true;
    	if (root.left == null || root.left == null || root.left.val != root.right.val) return false;
    	LinkedList<TreeNode> leftStack = new LinkedList<TreeNode> ();
    	LinkedList<TreeNode> rightStack = new LinkedList<TreeNode> ();
    	
    	Set<TreeNode> visited = new HashSet<TreeNode> ();
    	leftStack.push(root.left);
    	rightStack.push(root.right);
    	visited.add(root.left);
    	visited.add(root.right);
    	while (!leftStack.isEmpty() && !rightStack.isEmpty())
    	{
    		TreeNode iterLeft = leftStack.peek();
    		TreeNode iterRight = rightStack.peek();
    		if (iterLeft.val != iterRight.val) return false;
    		if (iterLeft.left != null && !visited.contains(iterLeft.left))
    			leftStack.add(iterLeft.left);
    		else if (iterLeft.right != null && !visited.contains(iterLeft.right))
    			leftStack.add(iterLeft.right);
    		else
    			rightStack.pop();
    		if (iterRight.right != null && !visited.contains(iterRight.right))
    			rightStack.add(iterRight.right);
    		else if (iterRight.left != null && !visited.contains(iterRight.left))
    			rightStack.add(iterRight.left);
    		else
    			rightStack.pop();
    		
    	}
    	if (leftStack.isEmpty() && rightStack.isEmpty())
    		return true;
    	return false;
    }
}
