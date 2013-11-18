package com.leetcode.oj.tree.traversal;

import java.util.ArrayList;

import com.leetcode.oj.common.model.TreeNode;

public class BinaryTreeMorrisTraversal 
{
	static ArrayList<Integer> inorderTraversal(TreeNode root)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
	       TreeNode  current,pre;

	       if(root == null)
	       return result;

	       current = root;
	       while(current != null)
	       {                
	             if(current.left == null)
	             {
	                    result.add(current.val);
	                    current = current.right;     
	             }   
	             else
	             {
	                    /* Find the inorder predecessor of current */
	                    pre = current.left;
	                    while(pre.right != null && pre.right != current)
	                           pre = pre.right;

	                    /* Make current as right child of its inorder predecessor */
	                    if(pre.right == null)
	                    {
	                           pre.right = current;
	                           current = current.left;
	                    }
	                   
	                    /* Revert the changes made in if part to restore the original
	                 tree i.e., fix the right child of predecssor */  
	                    else
	                    {
	                           pre.right = null;
	                           result.add(current.val);
	                           current = current.right;     
	                    } /* End of if condition pre.right == null */
	             } /* End of if condition current.left == null*/
	       } /* End of while */

	       return result;
	}
	
	public static void main (String[] args)
	{
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right= new TreeNode(6);
		root.right.right.left = new TreeNode(7);
		inorderTraversal(root);
	}
}
