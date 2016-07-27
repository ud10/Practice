/**
 * 
 */
package trees;

/**
 * @author uditgupta
 * May 31, 2016 2:22:05 PM
 */
public class MorrisTraversal {
	
	public static void main(String[] args) {
		
	}
	
	@SuppressWarnings("unused")
	private static void inOrder(TreeNode root){
		if(root == null)
			return;
		TreeNode cur = root;
		while(cur != null){
			if(cur.left == null){
				System.out.println(cur.val);
				cur = cur.right;
			}else{
				TreeNode pred = cur.left;
				while(pred.right != null && pred.right != cur){
					pred = pred.left;
				}
				if(pred.right == null){
					pred.right = cur;
					cur = cur.left;
				}else{
					pred.right = null;
					System.out.println(cur.val);
					cur = cur.right;
				}
			}
		}
	}
}
