package trees;
import java.util.*;
public class TwoSumBinaryTree {

	public static void main(String[] args) {

	}
	public int t2Sum(TreeNode A, int B) {
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = new Stack<TreeNode>();
	    boolean done1 = false, done2 = false;
	    int val1 = 0, val2 = 0;
	    TreeNode curr1 = A, curr2 = A;
	    while(true){
	        while(!done1){
	            if(curr1 != null){
	                s1.push(curr1);
	                curr1 = curr1.left;
	            }else{
	                if(s1.isEmpty())
	                    done1 = true;
	                else{
	                    curr1 = (TreeNode) s1.pop();
	                    val1 = curr1.val;
	                    curr1 = curr1.right;
	                    done1 = true;
	                }
	            }
	        }
	        while(!done2){
	            if(curr2 != null){
	                s2.push(curr2);
	                curr2 = curr2.right;
	            }else{
	                if(s2.isEmpty())
	                    done2 = true;
	                else{
	                    curr2 = (TreeNode) s2.pop();
	                    val2 = curr2.val;
	                    curr2 = curr2.left;
	                    done2 = true;
	                }
	            }
	        }
	        if((val1 != val2) && (val1 + val2) == B)
	            return 1;
	        else if((val1 + val2) < B)
	            done1 = false;
	        else if ((val1 + val2) > B)
	            done2 = false;
	        if (val1 >= val2)
	            return 0;
	    }
	}
}
