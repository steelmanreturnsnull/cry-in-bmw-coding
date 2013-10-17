package leetcode.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;

import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtil;


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
 * Future Thoughts: 
 * A threaded tree: A binary tree is threaded by making all right child 
 * pointers that would normally be null point to the inorder successor 
 * of the node, and all left child pointers that would normally be null point 
 * to the inorder predecessor of the node.
 */
public class SolvedBinaryTreeInorderTraversal {
	
	public static ArrayList<Integer> inorderTraversal(TreeNode root) 
	{
		ArrayList<Integer> list = new ArrayList<Integer> ();
		if (root == null)
			return list;
		list.addAll(inorderTraversal(root.left));
		list.add(root.val);
		list.addAll(inorderTraversal(root.right));
		return list;
    }
	
	// Improved: use less memory
	public static ArrayList<Integer> inorderTraversal2(TreeNode root) 
	{
		
		ArrayList<Integer> list = new ArrayList<Integer> ();
		inorderTraversal2(root, list);
		return list;
    }
	
	public static void inorderTraversal2(TreeNode root, ArrayList<Integer> list) 
	{
		
		if (root == null)
			return;
		inorderTraversal2(root.left, list);
		list.add(root.val);
		inorderTraversal2(root.right, list);
    }
		
	public static ArrayList<Integer> inorderTraversalIter(TreeNode root) 
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while (!stack.isEmpty() || root != null)
		{
			if (root != null)
			{
				stack.push(root);
				root = root.left;
			}
			else
			{
				root = stack.pop();
				result.add(root.val);
				root = root.right;
			}
		}
		return result;
	}
	
    public static void main(String[] args) 
	{
		for (int i=0; i<=10; i++)
		{
			TreeNode test = TreeUtil.constructFullTreeNode(i);
			ArrayList<Integer> l1 = inorderTraversal2(test);
			ArrayList<Integer> l2 = inorderTraversalIter(test);
			System.out.println("i = " + i + ":" + l1.equals(l2));
		}
	}
}
