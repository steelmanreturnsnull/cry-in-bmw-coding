package leetcode.tree.traversal.model;

import java.util.LinkedList;

import common.TreeNode;

public class TreeTraversal {

	@SuppressWarnings("unchecked")
	public static <T extends Traversable <? super T>> void inorderTraversal (TreeNode root, Class<?> T)  
	{
		try 
		{
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
					((Traversable<T>) T.newInstance()).visit(root);
					root = root.right;
				}
			}
		} catch (InstantiationException | IllegalAccessException ignored) {

		}
	}


}
