package common;

import java.util.LinkedList;


public class TreeUtil 
{
	/**
	The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

	Here's an example:

	   1
	  / \
	 2   3
	    /
	   4
	    \
	     5
	The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
	 */
	
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
		if (parts.length > 0 && !parts[i].equals("#"))
		{
			root = new TreeNode(Integer.valueOf(parts[i++]));
			unCompletedNode.add(root);
		}
		
		while (!unCompletedNode.isEmpty())
		{
			TreeNode iterNode = unCompletedNode.peek();
			String leftStr = parts[i++];
			if (!leftStr.equals("#"))
			{
				TreeNode left = new TreeNode(Integer.valueOf(leftStr));
				unCompletedNode.add(left);
				iterNode.left = left;
			}
			String rightStr = parts[i++];
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
	
	public static TreeNode contructFullTestTree (int level)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < Math.pow(2, level) -1; i++)
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
	
    public static void main (String[] args)
    {

    	
    }
}
