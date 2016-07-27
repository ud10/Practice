package linkedLists;
/**
 * Definition for binary tree
 */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
/**
 * Definition for singly-linked list.
 */
  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

public class SortedLLtoBalancedBST {
	static ListNode h;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		
		//TreeNode t = sortedListToBST(l);
	}
    private static int getLength(ListNode a){
        int len = 0;
        ListNode temp = a;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
	public static TreeNode sortedListToBST(ListNode a) {
	    if(a == null)
	        return null;
	    h = a;
	    int len = getLength(a);
	    return sortedListToBST(0, len -1);
	}
	public static TreeNode sortedListToBST(int start, int end){
	    if(start > end)
	        return null;
	    int mid = start + (end - start)/2;
	    TreeNode left = sortedListToBST(start, mid-1);
	    TreeNode root = new TreeNode(h.val);
	    root.left = left;
	    h = h.next;
	    root.right = sortedListToBST(mid+1, end);
	    return root;
	}
}
