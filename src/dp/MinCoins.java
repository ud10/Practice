package dp;
//import java.util.*;
public class MinCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {2, 5, 3};
        int sum = 7;
        System.out.println("Minimum number of coins: " + getMinCoinsDP(values, sum));
	}
	public static int getMinCoinsDP(int[] values, int sum) {
		int min_coins =0;
		int n = values.length;
		int[] dp = new int[sum+1];
		dp[0] = 0;
		for(int i=1;i<=sum;i++){
			min_coins = Integer.MAX_VALUE;
			for(int j=0;j<n;j++){
				if(i>=values[j])
					min_coins = Math.min(min_coins, dp[i-values[j]]);
			}
			if(min_coins != Integer.MAX_VALUE)
				dp[i] = min_coins +1;
			else
				dp[i] = Integer.MAX_VALUE;
		}
		return dp[sum];
	}
}
