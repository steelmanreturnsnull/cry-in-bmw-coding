package com.leetcode.oj.tree;

import com.leetcode.oj.common.TreeLinkNode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Note:
 * 
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
    After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */

// OK
public class PopulatingNextRightPointersInEachNodeII 
{
	// O(N) 
	// Level order traversal without the queue (the next pointer acted like the queue)
	public void connect(TreeLinkNode root) 
	{
		while (root != null)
		{
			TreeLinkNode nextNode = null; //first node in next level
			TreeLinkNode prevNode = null; //prev node when linking
			for (; root != null; root = root.next)
			{
				if (nextNode == null)
					nextNode = (root.left == null) ? root.right : root.left;
				
				if (root.left != null)
				{
					if (prevNode != null)
						prevNode.next = root.left;
					prevNode = root.left;
				}
				
				if (root.right != null)
				{
					if (prevNode != null)
						prevNode.next = root.right;
					prevNode = root.right;
				}
			}
			
			root = nextNode;
		}
    }
}
