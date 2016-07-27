package trees;
import java.util.*;
public class RootToLeafPathWithSum {
	/*
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
	 */
	public static void main(String[] args) {
		

	}
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    findPathSum(root, sum, new ArrayList<Integer>(), result);
	    return result;
	}
	private void findPathSum(TreeNode root, int sum, ArrayList<Integer> path, 
			ArrayList<ArrayList<Integer>> result){
		if(root == null)
			return;
		path.add(root.val);
		findPathSum(root.left, sum-root.val, path, result);
		findPathSum(root.right, sum-root.val, path, result);
		if(root.left == null && root.right == null && sum == root.val){
			ArrayList<Integer> al = new ArrayList<Integer>(path);
			result.add(al);
		}
		path.remove(path.size() - 1);
	}
}
