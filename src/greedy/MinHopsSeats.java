package greedy;
import java.util.*;
public class MinHopsSeats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "....x..xx...x..";
		String t = ".xxx";
		System.out.println("fjhdjhg");
		System.out.println(minMoves(t));
		System.out.println(minimumMove(s));
		//System.out.println(seats(s));
	}
	public static int minimumMove(String str) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'x') {
				list.add(i);
			}
		}
		if (list.size() <= 1) {
			return 0;
		}
		int minsum = Integer.MAX_VALUE;
		int size = list.size();
		int from = list.get(0);
		int to = list.get(list.size() - 1);
		for (int i = from; i <= to - size + 1; i++) {
			int sum = 0;
			for (int j = 0; j < size; j++) {
				sum += Math.abs(list.get(j) - i - j);
			}
			if (sum < minsum) {
				minsum = sum;
			}
		}
		return minsum;
	}
	public static int minMoves(String seats) {
		  // step 1. add all groups to dequeue
		  Deque<int[]> dq = new ArrayDeque<>();
		  int i = 0, j = 0, n = seats.length();
		  while (j < n) {
		    // skip '.'
		    while (j < n && seats.charAt(j) == '.') j++;
		    if (j == n) break;
		    // go through 'X'
		    for (i = j; j < n && seats.charAt(j) == 'x'; j++) {}
		    // add group to dequeue
		    dq.addLast(new int[]{i, j - 1});
		  }
		  // step 2. merge groups from both ends
		  int count = 0;
		  while (dq.size() > 1) {
		    int[] left = dq.peekFirst();
		    int[] right = dq.peekLast();

		    int lenLeft = left[1] - left[0] + 1;
		    int lenRight = right[1] - right[0] + 1;

		    if (lenLeft <= lenRight) {
		      // merge left two groups
		      left = dq.pollFirst();
		      int[] tmpl = dq.peekFirst();
		      count += lenLeft * (tmpl[0] - left[1] - 1);
		      tmpl[0] -= lenLeft;
		    } else {
		      // merge right two groups
		      right = dq.pollLast();
		      int[] tmpr = dq.peekLast();
		      count += lenRight * (right[0] - tmpr[1] - 1);
		      tmpr[1] += lenRight;
		    }
		  }
		  return count;
		}
	public static int seats(String a) {
	    int n = a.length();
        int k = 0;
        for(int i = 0; i < n; i++) {
          if (a.charAt(i) == 'x') {
            k++;
          }
        }
        System.out.println(k);
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n - k; j++) {
          int hops = 0, p = j;
          for (int i = 0; i < n; i++) {
            if (a.charAt(i) == 'x') {
              hops += Math.abs(i - p);
              p++;
            }
          }
          min = Math.min(min, hops);
        }
        return min;
	}
	int minJumpsOptimized(String s) {
		int i = findMedian(s.toCharArray());
		if (i == -1) {
			return 0;
		}
		return shift(s.toCharArray(), i);
	}

	// Shifts each person the the unoccupied seat closest to seat i.
	int shift(char s[], int i) {
		int count = 0;
		int j = 0;
		int k = i;
		while (j < k) {
			if (s[j] == '.') {
				j++;
			}
			else if (s[k] == 'x') {
				k--;
			}
			else {
				s[k] = s[j];
				s[j] = '.';
				count += k-j;
				j++;
				k--;
			}
		}
		j = s.length - 1;
		k = i;
		while (j > k) {
			if (s[j] == '.') {
				j--;
			}
			else if (s[k] == 'x') {
				k++;
			}
			else {
				s[k] = s[j];
				s[j] = '.';
				count += j-k;
				j--;
				k++;
			}
		}
		return count;
	}
	int findMedian(char s[]) {
		int count1 = 0;
		for (char c : s) {
			if (c == 'x') {
				count1++;
			}
		}
		if (count1 == 0) {
			return -1;
		}
		count1 = (count1 + 1) / 2;
		int count2 = 0;
		for (int i = 0; i < s.length; ++i) {
			if (s[i] == 'x') {
				count2++;
				if (count2 == count1) {
					return i;
				}
			}
		}
		throw new RuntimeException("yuk!");
	}
	public static int countMoves(String str){
		//find the median or median-like position
		int leftIndex = -1;
		int rightIndex = 15;
		while(leftIndex < rightIndex){
			leftIndex = findNext(1, str, leftIndex, 'x');
			rightIndex = findNext(-1, str, rightIndex, 'x');
		}
		int total = 0;
		//now move positions back towards the edges
		//start with the left
		//find first open position
		int open = findNext(-1, str, leftIndex, '.');
		//find first seated that needs to be moved
		leftIndex = findNext(-1, str, open, 'x');
		//now compute the move costs
		while(leftIndex > -1){
			total += open - leftIndex;
			open--;
			leftIndex = findNext(-1, str, leftIndex, 'x');
		}
		//now do the right
		open = findNext(1, str, rightIndex, '.');
		//find the first seated that needs to be moved
		rightIndex = findNext(1, str, open, 'x');
		//now compute the move costs
		while(rightIndex < 15){
			total += rightIndex - open;
			open++;
			rightIndex = findNext(1, str, rightIndex, 'x');
		}
		return total;
	}
		
	private static int findNext(int interval, String str, int currPos, char c){
		int index = currPos + interval;
		while(index < str.length() && index > -1){
			char checkC = str.charAt(index);
			if(checkC == c){
				return index;
			}
			index+= interval;
		}
		return index;
	}
}
