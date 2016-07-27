package dp;
import java.util.*;
public class BnSStockII {
	/*
	 * Say you have an array for which the i'th element is the price of a given stock on day i.
	 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
	 * (i.e., buy one and sell one share of the stock multiple times). However, you may not engage
	 * in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
	 */
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);a.add(2);
		int profit = maxProfit(a);
		System.out.println(profit);
	}
	public static int maxProfit(final List<Integer> a){
		int profit = 0;
		for(int i=1;i<a.size();i++){
			if(a.get(i)>a.get(i-1))
				profit += a.get(i)-a.get(i-1);
		}
		return profit;
	}

}
