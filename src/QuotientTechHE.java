import java.io.*;
class TreeNode {
	String name;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
}
public class QuotientTechHE {
	/*
	 * This problem is the fourth part of a multipart problem. Write a program that takes as input a description of a binary tree and finds the maximum depth of the tree. The input is a string that describes a tree. The format is as follows.

A node is represented as tuple of 3 strings: name, parent’s name, and data. Each node is enclosed by braces and each string is separated by hyphens. If a node has no parent, the string “null” is used for the parent’s name. For instance, suppose the string is “{root-null-1}”, then the name of the node is “root”, the node has no parent, and has “1” for the data. Using another example, suppose the string is “{child1-root-2}”, then the node is “child1”, the parent is the “root” node, and a data of “2”. The entire binary tree is defined as a list of nodes. For instance,

“{root-null-1}{child1-root-2}{child2- root-2}{grandchild11-child1-3}{grandchild21-child2-4}{grandchild12-child1-4}{greatgrandchild211-grandchild21-4}”.

There is exactly one root node (i.e., a node without a parent) As an illustration, suppose that the input string is

“{root-null-1}{child1-root-2}{child2- root-2}{grandchild11-child1-3}{grandchild21-child2-4}{grandchild12-child1-4}{greatgrandchild211-grandchild21-4}”.

The program should be perform as follows.

Parses the input and construct a data structure in-memory to represent the binary tree. The data structure is then used to determine the maximum depth of the tree. This problem will test your ability to read and parse a textual representation of a semi-complex data structure, build that data structure in memory, and then algorithmically process the data.

The program should not assume that the input string is in the correct format; if the input string is in the wrong format, it should just return a result of “Bad Input”. Similarly, the program should not assume that a proper binary tree can be formed; in which case, the program should return a result of “Bad Tree”. If the input contains a valid, then the program should be able to construct a tree regardless of the order of the nodes in the input string. A special case of a bad tree that can occur here is cycles, the program should be able to detect these cycles and return a result of “Bad Tree”.

Sample inputs :

Input of the program will be: ‪{z-null-1}{a-z-a}{b-z-b}{c-b-a}{d-c-b}{e-a-d}{f-a-d}{g-d-a}{h-d-f}{i-f-f}{j-g-e}{k-j-e}{l-j-e}{m-k-e}{n-e-e}‬‬

Expected Output - 8

Input of the program- {root-null-root}{child1-root-child1}{child2-root-child2}{gc11-child1-gc11}{gc12-child1-gc12}{gc21-child2-gc21}{ggc211-gc21-ggc211}

Expected Output-4
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        //String line ="{root-null-root}{child1-root-child1}{child2-root-child2}{gc11-child1-gc11}{gc12-child1-gc12}{gc21-child2-gc21}{ggc211-gc21-ggc211}";
		String[] str = null;
		str = line.split("}");
		TreeNode root = new TreeNode();
		for(int i =0;i<str.length;i++){
			System.out.println(str[i]);
			String[] s = str[i].substring(1).split("-");
			if(s[1].equals("null")){
				root.name = s[0];
				root.parent = null;
				root.left = null;
				root.right = null;
			}else{
				TreeNode node = new TreeNode();
				node.name = s[0];
				TreeNode p = getParent(root, s[1]);
				if(p != null){
					if(p.left == null)
						p.left = node;
					else
						p.right = node;
				}
				node.parent = p;
				node.left = null;
				node.right = null;
			}
		}
		
		System.out.println(line);
		System.out.println(maxDepth(root));
	}
	private static TreeNode getParent(TreeNode root, String s){
		if(root == null)
			return root;
		if(root.name.equals(s))
			return root;
		TreeNode parent = null;
		if(root.left != null)
			parent = getParent(root.left, s);
		if(root.right != null)
			parent = getParent(root.right, s);
		return parent;
	}
//	private static boolean isTreeBad(TreeNode node){
//    	return false;
//    }
//    private static boolean isInputBad(String line){
//    	return false;
//    } 
    private static int maxDepth(TreeNode node){
    	if(node == null)
    		return 0;
    	int leftDepth = maxDepth(node.left);
    	int rightDepth = maxDepth(node.right);
    	
    	return leftDepth > rightDepth ? leftDepth+1 : rightDepth+1;
    }
}
