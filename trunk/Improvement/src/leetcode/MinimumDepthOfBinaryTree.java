package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class MinimumDepthOfBinaryTree {
	
    public boolean isLeaf(TreeNode root) { 
		return (root !=null && root.left ==null && root.right ==null);
	}
    
    int minDepth(TreeNode root) {
    	Queue<TreeNode> treeQueue = new LinkedList<TreeNode> ();
    	Queue<Integer> heightQueue = new LinkedList<Integer> ();
    	if (root == null)
    		return 0;
    	treeQueue.add(root);
    	heightQueue.add(1);
    	while (!treeQueue.isEmpty()) {
    		TreeNode current = treeQueue.remove();
    		int height = heightQueue.remove();
    		if (isLeaf(current))
    			return height;
    		else {
    			if (current.left != null) {
    				treeQueue.add(current.left);
    				heightQueue.add(height+1);
    			}
    			if (current.right != null) {
    				treeQueue.add(current.right);
    				heightQueue.add(height+1);
    			}
    		}
    	}
    	return -1;
    }
}
