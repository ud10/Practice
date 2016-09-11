/**
 * 
 */
package trees;

class Node{
	int val;
	Node left;
	Node right;
	Node next;
}
/**
 * @author uditgupta
 * Sep 11, 2016 10:51:30 AM
 */
public class PopulateNextRightRecursive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	private static Node getRight(Node p){
		Node t = p.next;
		while(t != null){
			if(t.left != null)
				return t.left;
			if(t.right != null)
				return t.right;
			t = t.next;
		}
		return null;
	}
	private static void populateNextRight(Node p){
		if(p == null)
			return;
		if(p.next != null)
			populateNextRight(p.next);
		if(p.left != null){
			if(p.right != null){
				p.left.next = p.right;
				p.right.next = getRight(p);
			}else
				p.left.next = getRight(p);
			populateNextRight(p.left);
		}else if(p.right != null){
			p.right.next = getRight(p);
			populateNextRight(p.right);
		}else
			populateNextRight(getRight(p));
	}

}
