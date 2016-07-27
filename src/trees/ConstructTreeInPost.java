package trees;
import java.util.ArrayList;
public class ConstructTreeInPost {

	public static void main(String[] args) {

	}
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
	    int inSt = 0;
	    int inEn = inorder.size()-1;
	    int postStart = 0;
		int postEnd = postorder.size() - 1;
	    return buildTree(postorder, inorder, inSt, inEn, postStart, postEnd);
	}
	public TreeNode buildTree(ArrayList<Integer> postorder, ArrayList<Integer> inorder, int inSt, int inEn, int postStart, int postEnd){
	    if(inSt > inEn)
	        return null;
	    TreeNode t = new TreeNode(postorder.get(postEnd));
	    if(inSt == inEn)
	        return t;
	    int bId = 0;
	    for(int i = inSt; i <= inEn; i++){
	        if(t.val == inorder.get(i)){
	            bId = i; break;
	        }
	    }
	    t.left = buildTree(postorder, inorder, inSt, bId-1, postStart, postStart + bId - (inSt + 1));
	    t.right = buildTree(postorder, inorder, bId+1, inEn, postStart + bId- inSt, postEnd - 1);
	    
	    return t;
	}
}
