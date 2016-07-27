/**
 * 
 */
package trees;

/**
 * @author uditgupta
 * May 25, 2016 11:15:19 AM
 */
public class MaxDiffNodeAncestor {
	static int diff = 0;
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(8);
		
		System.out.println(maxDiff(root));
	}
	private static int maxDiff(TreeNode root){
		if(root == null)
			return Integer.MAX_VALUE;
		if(root.left == null && root.right == null)
			return root.val;
		int minVal = Math.min(maxDiff(root.left), maxDiff(root.right));
		diff = Math.max(diff, root.val - minVal);
		return diff;
	}

}
