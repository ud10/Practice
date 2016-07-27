/**
 * 
 */
package trees;

/**
 * @author uditgupta
 * Jun 30, 2016 11:21:17 PM
 */
public class ConvertToSumTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(8);
		System.out.println("Before sum");
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		sumTree(root);
		System.out.println("After sum");
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
	}
	public static int sumTree(TreeNode root){
		if(root == null)
			return 0;
		int oldVal = root.val;
		int l=0,r=0;
		if(root.left != null)
			l = sumTree(root.left);
		if(root.right != null)
			r = sumTree(root.right);
		root.val = l+r;
		return oldVal + root.val;

	}
}
