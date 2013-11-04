package com.leetcode.oj.common;

import java.util.LinkedList;

import com.leetcode.oj.common.model.TreeNode;

/**
 * The serialization of a binary tree follows a level order traversal, 
 * where '#' signifies a path terminator where no node exists below.
 * 
 * Here's an example:
 * 
   1
  / \
 2   3
    /
   4
    \
     5
     
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 * 
 */

// OK
public class TreeUtil 
{
	private static String[] split (String s)
	{
		String trim = s.substring(1, s.length()-1);
		return trim.split(",");
	}
	
	public static TreeNode constructTreeNode(String s) 
	{
		String[] parts = split(s);
		TreeNode root = null;
		LinkedList<TreeNode> unCompletedNode = new LinkedList<TreeNode> ();
		
		int i = 0;
		if (!parts[i].isEmpty() && !parts[i].equals("#"))
		{
			root = new TreeNode(Integer.valueOf(parts[i++]));
			unCompletedNode.add(root);
		}
		
		while (!unCompletedNode.isEmpty())
		{
			TreeNode iterNode = unCompletedNode.peek();
			
			String leftStr = null;
			if (i < parts.length)
				leftStr = parts[i++];
			else
				break;
			if (!leftStr.equals("#"))
			{
				TreeNode left = new TreeNode(Integer.valueOf(leftStr));
				unCompletedNode.add(left);
				iterNode.left = left;
			}
			
			String rightStr = null;
			if (i < parts.length)
				rightStr = parts[i++];
			else
				break;
			if (!rightStr.equals("#"))
			{
				TreeNode right = new TreeNode(Integer.valueOf(rightStr));
				unCompletedNode.add(right);
				iterNode.right = right;
			}
			unCompletedNode.pop();
		}
		
		return root;
	}
	
	public static TreeNode constructFullTreeNode (int level)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 1; i <= Math.pow(2, level) -1; i++)
		{
			sb.append(i).append(",");
		}
		for (int i = 0; i <= Math.pow(2, level) -1; i++)
		{
			sb.append("#").append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("}");
		return constructTreeNode(sb.toString());
	}
	
	public static TreeNode getCommonTrees (int id)
	{
		switch (id)
		{
			case 0:
				return constructTreeNode("{}");
			case 1:
				return constructTreeNode("{#}");
			case 2:
				return constructTreeNode("{0}");
			case 3:
				return constructTreeNode("{1,2}");
			case 4:
				return constructTreeNode("{1,#,2}");
			case 5:
				return constructTreeNode("{0,1,1}");
			case 6:
				return constructTreeNode("{1,#,3,#,5}");
			case 7:
				return constructTreeNode("{1,2,3,4,#,#,5}");
			case 8:
				return constructTreeNode("{2,#,3,#,4,#,5,#,6}");
			case 9:
				return constructTreeNode("{0,0,0,0,#,#,0,#,#,#,0}");
			default:
				return constructTreeNode("{1,2,#,3,#,4,#,5}");
		}
	}

	@SuppressWarnings("unused")
	public static void main (String[] args) 
	{
		for (int i = 0; i < 10; i++)
		{
			TreeNode a = getCommonTrees(i);
		}
		
		for (int i = 0; i < 10; i++)
		{
			TreeNode a = constructFullTreeNode(i);
		}
	}
}
