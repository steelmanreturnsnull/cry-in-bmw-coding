package common;

// Definition for binary tree
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; left =null; right = null; }
    
    public static boolean isLeaf(TreeNode t)
    {
    	return (t!=null && t.left==null && t.right==null);
    }
    
    public static int getHeight(TreeNode t)
    {
    	if (t==null)
    		return -1;
    	if (isLeaf(t))
    		return 0;
    	else
    		return Math.max(getHeight(t.left), getHeight(t.right));
    }
    
    
}