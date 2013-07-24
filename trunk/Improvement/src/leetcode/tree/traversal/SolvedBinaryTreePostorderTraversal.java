package leetcode.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;

import common.TreeNode;
import common.TreeUtil;

/* Note: 
 * Preorder: visit the node the 1st time
 * Inorder: visit the node the 2nd time
 * Postorder: visit the node the 3rd time
 */

public class SolvedBinaryTreePostorderTraversal {
	public static ArrayList<Integer> postorderTraversal2(TreeNode root) 
	{
		
		ArrayList<Integer> list = new ArrayList<Integer> ();
		postorderTraversal2(root, list);
		return list;
    }
	
	public static void postorderTraversal2(TreeNode root, ArrayList<Integer> list) 
	{
		
		if (root == null)
			return;
		postorderTraversal2(root.left, list);
		postorderTraversal2(root.right, list);
		list.add(root.val);
    }
	
	public static ArrayList<Integer> postorderTraversalIter(TreeNode root) 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		TreeNode prev = null;
		while (!stack.isEmpty())
		{
			root = stack.peek();
			if (prev == null || prev.left == root || prev.right == root) //First Time
			{
				if (root.left != null)
				{
					stack.push(root.left);
				}
				else if (root.right != null)
				{
					stack.push(root.right);
				}
			}
			else if (root.left == prev) //Second Time
			{
				if (root.right != null)
					stack.push(root.right);
			}
			else //Third Time
			{
				result.add(root.val);
				stack.pop();
			}
			prev = root;
		}
		return result;
	}
	
    public static void main(String[] args) 
	{
		for (int i=0; i<=10; i++)
		{
			TreeNode test = TreeUtil.contructFullTestTree(i);
			ArrayList<Integer> l1 = postorderTraversal2(test);
			ArrayList<Integer> l2 = postorderTraversalIter(test);
			System.out.println("i = " + i + ":" + l1.equals(l2));
		}
	}
}
