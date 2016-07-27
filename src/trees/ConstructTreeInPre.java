package trees;
import java.util.*;
public class ConstructTreeInPre {
	static int preId = 0;
	public static void main(String[] args) {
		
		ArrayList<Integer> preorder = new ArrayList<Integer>();
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		preorder.add(1);preorder.add(2);preorder.add(3);preorder.add(4);preorder.add(5);
		inorder.add(3);inorder.add(2);inorder.add(4);inorder.add(1);inorder.add(5);
		TreeNode x = buildTree(preorder, inorder);
		printInorder(x);
	}
	public static void printInorder(TreeNode x){
		if(x == null)	return;
		printInorder(x.left);
		System.out.println(x.val);
		printInorder(x.right);
	}
	public static TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
	    int inSt = 0;
	    int inEn = inorder.size()-1;
	    return buildTree(preorder, inorder, inSt, inEn);
	}
	public static TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder, int inSt, int inEn){
	    if(inSt > inEn)
	        return null;
	    TreeNode t = new TreeNode(preorder.get(preId));
	    preId++;
	    //System.out.println(preId);
	    if(inSt == inEn)
	        return t;
	    int bId = 0;
	    for(int i = inSt; i <= inEn; i++){
	        if(t.val == inorder.get(i)){
	            bId = i; break;
	        }
	    }
	    t.left = buildTree(preorder, inorder, inSt, bId-1);
	    t.right = buildTree(preorder, inorder, bId+1, inEn);
	    
	    return t;
	}

}
