package dp;
import java.util.*;
public class MinPathSum {
	/*
	 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
	 * which minimizes the sum of all numbers along its path.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> inner = new ArrayList<Integer>();   
		inner.add(1);inner.add(5);inner.add(3);inner.add(2);
		outer.add(inner);
		ArrayList<Integer> inner1 = new ArrayList<Integer>(inner);
		outer.add(inner1);
		System.out.println("R1 size: "+ inner.size() + " & R2 size: "+inner1.size() + " & No. Rows: "+ outer.size());
		int s = minPathSum(outer);
		System.out.println(s);
	}
	public static int minPathSum(ArrayList<ArrayList<Integer>> a) {
		int rows = a.size();
		int cols = a.get(0).size();
		int[][] dp = new int[rows][cols];
		dp[0][0] = a.get(0).get(0);
    	for(int i=1; i<cols; i++){
            dp[0][i] = dp[0][i-1] + a.get(0).get(i);
    	}
        for(int j=1; j<rows; j++){
            dp[j][0] = dp[j-1][0] + a.get(j).get(0);
        }
		for(int i=1;i<rows;i++){
			for(int j=1;j<cols;j++){
				dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + a.get(i).get(j); 
			}
		}
		return dp[rows-1][cols-1];
	}
}
