package linkedLists;

public class SwapPairs {

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b; b.next = c; c.next = d; d.next = null;
		
		ListNode res = swapPairsIterative(a);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
		//ListNode res1 = swapPairsRecursive(a);
	}
	public static ListNode swapPairsIterative(ListNode a) {
		if(a == null || a.next == null)
			return a;
		ListNode pre = a;
		ListNode cur = a.next;
		a = cur;
		while(true){
			ListNode next = cur.next;
			cur.next = pre;
			if(next == null || next.next == null){
				pre.next = next; break;
			}
			pre.next = next.next;
			pre = next;
			cur = pre.next;
		}
		return a;
	}
	public static ListNode swapPairsRecursive(ListNode a) {
		
		return null;
	}
}
