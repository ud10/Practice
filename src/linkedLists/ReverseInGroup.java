package linkedLists;

public class ReverseInGroup {

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		a.next = b; b.next = c; c.next = d; d.next = e; e.next = f; f.next = null;
		int k = 3;
		ListNode res = reverse(a, k);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
	}
	public static ListNode reverse(ListNode a, int k) {
		ListNode cur = a;
		ListNode pre = null;
		ListNode next = null;
		int count = 0;
		while(count < k && cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			count++;
		}
		if(next != null){
			a.next = reverse(next, k);
		}
		
		return pre;
	}
}
