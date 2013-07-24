package leetcode.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;

import common.TreeNode;
import common.TreeUtil;

public class SolvedBinaryTreePreorderTraversal {
	public static ArrayList<Integer> preorderTraversal2(TreeNode root) 
	{
		
		ArrayList<Integer> list = new ArrayList<Integer> ();
		preorderTraversal2(root, list);
		return list;
    }
	
	public static void preorderTraversal2(TreeNode root, ArrayList<Integer> list) 
	{
		
		if (root == null)
			return;
		list.add(root.val);
		preorderTraversal2(root.left, list);
		preorderTraversal2(root.right, list);
    }
	
	public static ArrayList<Integer> preorderTraversalIter(TreeNode root) 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while (!stack.isEmpty() || root!=null)
		{
			if (root != null)
			{
				result.add(root.val);
				if (root.right != null)
				{
					stack.push(root.right);
				}
				root = root.left;
			}
			else
			{
				root = stack.pop();
			}
		}
		return result;
	}
	
    public static void main(String[] args) 
	{
		for (int i=0; i<=10; i++)
		{
			TreeNode test = TreeUtil.contructFullTestTree(i);
			ArrayList<Integer> l1 = preorderTraversal2(test);
			ArrayList<Integer> l2 = preorderTraversalIter(test);
			System.out.println("i = " + i + ":" + l1.equals(l2));
		}
	}
}
