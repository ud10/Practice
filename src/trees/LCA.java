package trees;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
public class LCA {
		static boolean v1 = false, v2 = false;
		public static void main(String args[]){
			TreeNode root = new TreeNode(5);
			root.left = new TreeNode(4);
			root.right = new TreeNode(3);
			root.left.left = new TreeNode(2);
			root.left.right = new TreeNode(1);
			root.right.left = new TreeNode(7);
			root.right.right = new TreeNode(8);
			int l = lca(root,3,4);
			System.out.println(l);
		} 
		public static int lca(TreeNode a, int val1, int val2){
	        v1 = isPresent(a, val1);
	        v2 = isPresent(a, val2);
	        if(v1 && v2){
	        	return lcaUtil(a, val1, val2);
	        }
	        return -1;
	    }
		public static int lcaUtil(TreeNode a, int val1, int val2){
			if(a == null)
					return -1;
        	if(a.val == val1 || a.val == val2){
		        return a.val;
		    }
		    int l = lcaUtil(a.left, val1, val2);
		    int r = lcaUtil(a.right, val1, val2);
		    if(l != -1 && r != -1)
		        return a.val;
		    return (l != -1) ? l : r;       
	    }
	    public static boolean isPresent(TreeNode a, int val){
	        if(a==null)
	        	return false;
	    	if(a.val == val)
	            return true;
	        return isPresent(a.left, val) || isPresent(a.right, val);	       
	    }
}
