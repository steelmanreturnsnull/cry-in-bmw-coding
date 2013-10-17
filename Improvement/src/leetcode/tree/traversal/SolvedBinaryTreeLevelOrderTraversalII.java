package leetcode.tree.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtil;


/**
 * Given a binary tree, return the bottom-up level order 
 * traversal of its nodes' values. (ie, from left to right, 
 * level by level from leaf to root).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
   
 *return its bottom-up level order traversal as:

[
  [15,7]
  [9,20],
  [3],
]

 */
public class SolvedBinaryTreeLevelOrderTraversalII {
	public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		LinkedList<TreeNode> currentQueue = new LinkedList<TreeNode> ();
		int nodes_this_level = 0;
		int nodes_next_level = 0;
		ArrayList<Integer> res = new ArrayList<Integer> ();
		if (root != null)
		{
			currentQueue.add(root);
			nodes_this_level ++;
		}
		while (!currentQueue.isEmpty())
		{
			TreeNode t = currentQueue.pop();
			res.add(t.val);
			if (t.left != null)
			{
				currentQueue.add(t.left);
				nodes_next_level++;
			}
			if (t.right != null)
			{
				currentQueue.add(t.right);
				nodes_next_level++;
			}

			nodes_this_level--;
			if (nodes_this_level == 0)
			{
				result.add(res);
				res = new ArrayList<Integer> ();
				nodes_this_level = nodes_next_level;
				nodes_next_level = 0;
			}
		}
		Collections.reverse(result);
		return result;
	}

    
    
    public static void main(String[] args) 
	{
		for (int i=0; i<=3; i++)
		{
			TreeNode test = TreeUtil.constructFullTreeNode(i);
			levelOrderBottom(test);
			System.out.println();
		}
	}
}
