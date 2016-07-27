package dp;
import java.util.*;
public class BnSStockIII {
	/*
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
	 */
	public static void main(String[] args) {

	}
	public int maxProfit(final List<Integer> a) {
		int n = a.size();
		if (n < 2) {
			return 0;
		}
		/*  We use left[i] to track the maximum profit for transactions before i, and use right[i] to track 
		 *  the maximum profit for transactions after i.
		 */
		//highest profit in 0 ... i
		int[] left = new int[n];
		int[] right = new int[n];
	 
		// DP from left to right
		left[0] = 0; 
		int min = a.get(0);
		for (int i = 1; i < n; i++) {
			min = Math.min(min, a.get(i));
			left[i] = Math.max(left[i - 1], a.get(i) - min);
		}
	 
		// DP from right to left
		right[n - 1] = 0;
		int max = a.get(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			max = Math.max(max, a.get(i));
			right[i] = Math.max(right[i + 1], max - a.get(i));
		}
	 
		int profit = 0;
		for (int i = 0; i < n; i++) {
			profit = Math.max(profit, left[i] + right[i]);
		}
	 
		return profit;
	}
}
