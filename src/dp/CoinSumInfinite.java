package dp;
import java.util.*;
public class CoinSumInfinite {
	/*
	 * You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of 
	 * each coin in the set. Note : Coins in set S will be unique. 
	 * Expected space complexity of this problem is O(N).
	 */
	public static void main(String[] args) {
		
	}
	public int coinchange2(ArrayList<Integer> a, int b) {
         int m = a.size();
         int table[] = new int[b+1];
         for(int i=0;i<table.length;i++)
             table[i] = 0;
         table[0] = 1;
         for(int i=0; i<m; i++){
             for(int j=a.get(i); j<=b; j++){
                 table[j] += table[j-a.get(i)];
             }
         }
         return table[b] % 1000007;
         //Alternative Solution
         // return coin(a, m, b);
	}
	public int coin(ArrayList<Integer> a, int m, int n){
        int i, j, x, y;
        int[][] table = new int[n+1][m];
        for(i=0; i<m; i++)
            table[0][i] = 1;
        for(i = 1; i < n+1; i++){
            for (j = 0; j < m; j++){
                x = (i-a.get(j) >= 0)? table[i - a.get(j)][j] : 0;
                y = (j >= 1)? table[i][j-1]: 0;
                table[i][j] = x + y;
            }
        }
	    return table[n][m-1] % 1000007;
	}
}
