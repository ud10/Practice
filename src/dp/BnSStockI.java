package dp;
import java.util.*;
public class BnSStockI {
	/*
	 * Say you have an array for which the i'th element is the price of a given stock on day i.
	 * If you were only permitted to complete at most one transaction (i.e., buy one and sell 
	 * one share of the stock), design an algorithm to find the maximum profit.
	 */
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);a.add(2);
		int profit = maxProfit(a);
		System.out.println(profit);
	}
	public static int maxProfit(final List<Integer> a) {
	    int profit = 0;
	    int min = Integer.MAX_VALUE;// or min = a[0];
	    for(int i=0;i<a.size();i++){
	        profit = Math.max(profit, a.get(i) - min);
	        min = Math.min(min, a.get(i));
	    }
	    return profit;
	}

}
