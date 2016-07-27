package dp;
import java.util.ArrayList;
public class DungeonPrincess {

	public static void main(String[] args) {

	}
	public int calculateMinimumHP(ArrayList<ArrayList<Integer>> a) {
		int m = a.size();
		int n = a.get(0).size();
	    int[][] dp = new int[m][n];
	    dp[m-1][n-1] = Math.max(1 - a.get(m-1).get(n-1), 1);
	    for(int i = m-2;i>=0;i--){
	    	dp[i][n-1] = Math.max(dp[i+1][n-1] - a.get(i).get(n-1), 1);
	    }
	    for(int i = n-2;i>=0;i--){
	    	dp[m-1][i] = Math.max(dp[m-1][i+1] - a.get(m-1).get(i), 1);
	    }
	    for(int i = m-2; i>=0;i--){
	    	for(int j = n-2; j>=0;j--){
	    		int x = Math.max(dp[i+1][j] - a.get(i).get(j), 1);
	    		int y = Math.max(dp[i][j+1] - a.get(i).get(j), 1);
	    		dp[i][j] = Math.min(x, y);
	    	}
	    }
		return dp[0][0];
	}
}
