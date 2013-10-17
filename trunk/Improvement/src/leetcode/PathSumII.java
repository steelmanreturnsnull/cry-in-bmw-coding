package leetcode;

import java.util.ArrayList;
import java.util.Stack;

import com.leetcode.oj.common.TreeNode;


public class PathSumII {
	
//	public static void main(String [ ] args) {
//		pathSum(new TreeNode(1), 1);
//	}
	
    public boolean isLeaf(TreeNode root) { 
		return (root !=null && root.left ==null && root.right ==null);
	}
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
    	Stack<TreeNode> treeStack = new Stack<TreeNode> ();
    	Stack<Integer> partialSum = new Stack<Integer> ();
    	Stack<ArrayList<Integer>> partialPath = new Stack<ArrayList<Integer>> ();
    	if (root == null)
    		return result;
    	treeStack.add(root);
    	partialSum.add(root.val);
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(root.val);
		partialPath.add(path);
    	while (!treeStack.isEmpty()) {
    		TreeNode current = treeStack.pop();
    		int current_sum = partialSum.pop();
    		ArrayList<Integer> current_path = partialPath.pop();
    		if (isLeaf(current) && current_sum == sum)
    			result.add(current_path);
    		else {
    			if (current.left != null) {
    				treeStack.push(current.left);
    				partialSum.push(current_sum + current.left.val);
    				ArrayList<Integer> new_path = new ArrayList<Integer>(current_path);
    				new_path.add(current.left.val);
    				partialPath.push(new_path);
    			}
    			if (current.right != null) {
    				treeStack.push(current.right);
    				partialSum.push(current_sum + current.right.val);
    				ArrayList<Integer> new_path = new ArrayList<Integer>(current_path);
    				new_path.add(current.right.val);
    				partialPath.push(new_path);
    			}
    		}
    	}
    	return result;
    }
}
