package trees;

import java.util.Stack;

public class FlattenTreeToList {

	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		a.left = new TreeNode(2);
		a.right = new TreeNode(3);
		TreeNode result = flatten(a);
		TreeNode t = result;
		while(t != null){
			System.out.println(t.val);
			t = t.right;
		}
	}
	public static TreeNode flatten(TreeNode a) {
		if(a == null)
			return a;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode p = a;
		while(!s.empty() || p != null){
			if(p.right != null)
				s.push(p.right);
			if(p.left != null){
				p.right = p.left;
				p.left = null;
			}else if(!s.empty()){
				TreeNode temp = s.pop();
				p.right = temp;
			}
			p = p.right;
		}
		return a;
	}
}
