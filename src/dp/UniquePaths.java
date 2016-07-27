package dp;
import java.util.*;
public class UniquePaths {

	public static void main(String[] args) {

	}
	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
		int r = a.size();
		int c = a.get(0).size();
		if(a.get(0).get(0)==1||a.get(r-1).get(c-1)==1) 
            return 0;
		int[][] dp = new int[r][c];
		dp[0][0] = 1;
		for(int i=1;i<r;i++){
			if(a.get(i).get(0) ==1)
				dp[i][0] = 0;
			else 
			    dp[i][0] = dp[i-1][0];
		}
		for(int j=1;j<c;j++){
			if(a.get(0).get(j) ==1)
				dp[0][j] = 0;
			else 
			    dp[0][j] = dp[0][j-1];
		}
		for(int i=1;i<r;i++){
			for(int j=1;j<c;j++){
				if(a.get(i).get(j) != 1){
					dp[i][j] = dp[i-1][j]+dp[i][j-1];
				}else
				    dp[i][j] = 0;
			}
		}
		return dp[r-1][c-1];
	}
}
