package dp;

import java.util.ArrayList;

public class SubsetSum {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);a.add(7);a.add(15);
		a.add(29);a.add(11);a.add(9);
		System.out.println(subsetSum(a));
	}
	 public static boolean subsetSum(ArrayList<Integer> a) {
		 int n = a.size();
		 int sum = 0;
		 for(int i =0;i<n;i++){
			 sum += a.get(i);
		 }
		 boolean[][] dp = new boolean[sum/2 + 1][n+1];
		 for(int i = 0;i<=n;i++)
			 dp[0][i] = true;
		 for(int i = 1; i <= sum/2; i++)
			 dp[i][0] = false;
		 
		 for(int i = 1; i <= sum/2; i++){
			 for(int j = 1; j <= n; j++){
				 dp[i][j] = dp[i][j-1];
	                if(i >= a.get(j-1))
	                    dp[i][j] = dp[i][j] || dp[i - a.get(j-1)][j-1];
	         }
	     }
		 return dp[sum/2][n];
	 }
}
