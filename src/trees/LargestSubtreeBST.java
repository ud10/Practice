/**
 * 
 */
package trees;

/**
 * @author uditgupta
 * Jun 6, 2016 1:18:46 AM
 */
public class LargestSubtreeBST {

	public static void main(String[] args) {
		
	}
	TreeNode largestBST(TreeNode root){
		TreeNode p = null;
		largestBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, p);
		return null;
	}
	int largestBST(TreeNode root, int min, int max, int numNodes, TreeNode p){
		if(root == null)
			return 0;
		boolean isBST = true;
		int leftSize = largestBST(root.left, min, max, numNodes, p);
		int curMin = leftSize == 0 ? root.val : min;
		if(leftSize == -1 || (leftSize !=0 && p.val <= max))
			isBST = false;
		
		int rightSize = largestBST(root.right, min, max, numNodes, p);
		int curMax = rightSize == 0 ? root.val : max;
		if(rightSize == -1 || (rightSize !=0 && p.val >= min))
			isBST = false;
		
		if(isBST){
			min = curMin; max = curMax;
			int totalNodes = leftSize + rightSize + 1;
			if(totalNodes > numNodes){
				numNodes = totalNodes;
				p = root;
			}
			return totalNodes;
		}else
			return -1;
	}
}
