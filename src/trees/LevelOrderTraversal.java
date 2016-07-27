package trees;
import java.util.*;
/**
 * Definition for binary tree
 */
// class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//  }

	
public class LevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(8);
		//ArrayList<ArrayList<Integer>> result = levelOrder(root);
		//System.out.println(l);

	}
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(a == null)
			return result;
		ArrayList<Integer> level = new ArrayList<Integer>();
		LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		cur.add(a);
		while(!cur.isEmpty()){
			TreeNode n = cur.remove();
			if(n.left != null)
				next.add(n.left);
			if(n.right != null)
				next.add(n.right);
			level.add(n.val);
			if(cur.isEmpty()){
				cur = next;
				next = new LinkedList<TreeNode>();
				result.add(level);
				level = new ArrayList<Integer>();
			}
		}
		return result;
	}
}