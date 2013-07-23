package common;


public class Util 
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
		String trim = s.substring(1, s.length()-2);
		return trim.split(",");
	}
	
	public static TreeNode constructTreeNode(String s) 
	{
		String[] parts = split(s);
		TreeNode root = null;
		if (parts.length > 0)
			
	}
}
