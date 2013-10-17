package leetcode.tree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;

import com.leetcode.oj.common.TreeNode;
import com.leetcode.oj.common.TreeUtil;


/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
   
 * return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
 * Mistake: didn't clear nextQueue
 */
public class SolvedBinaryTreeLevelOrderTraversal {
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
    	ArrayList<TreeNode> currentQueue = new ArrayList<TreeNode> ();
    	ArrayList<TreeNode> nextQueue = new ArrayList<TreeNode> ();
        if (root != null)
        	currentQueue.add(root);
        while (!currentQueue.isEmpty())
        {
        	ArrayList<Integer> res = new ArrayList<Integer> ();
        	nextQueue = new ArrayList<TreeNode> ();
        	for (TreeNode t : currentQueue)
        	{
        		res.add(t.val);
        		if (t.left != null)
        			nextQueue.add(t.left);
        		if (t.right != null)
        			nextQueue.add(t.right);
        	}
        	result.add(res);
        	
        	currentQueue = nextQueue;
        }
        return result;
    }
    
    // Without using second queue (This is much better!)
    public static ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {
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
        return result;
    }
    
    // Without using DFS
    public static ArrayList<ArrayList<Integer>> levelOrder3(TreeNode root) 
	{
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		preorderTraversal2(root, result, 0);
		return result;
    }
	
	public static void preorderTraversal2(TreeNode root, ArrayList<ArrayList<Integer>> result, int depth) 
	{
		
		if (root == null)
			return;
		if (depth == result.size())
		{
			ArrayList<Integer> res = new ArrayList<Integer> ();
			res.add(root.val);
			result.add(res);
		}
		else if (depth < result.size())
		{
			result.get(depth).add(root.val);
		}
		preorderTraversal2(root.left, result, depth+1);
		preorderTraversal2(root.right, result, depth+1);
    }
    
    public static void main(String[] args) 
	{
		for (int i=0; i<=3; i++)
		{
			TreeNode test = TreeUtil.constructFullTreeNode(i);
			levelOrder3(test);
			System.out.println();
		}
	}
}
