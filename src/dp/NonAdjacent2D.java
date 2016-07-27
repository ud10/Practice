package dp;
import java.util.*;
public class NonAdjacent2D {
//	private int n = 1000000;
//    int[] dp = new int[n];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	} 
	public int adjacent(ArrayList<ArrayList<Integer>> a) {
	   int s = a.get(0).size();
	   int[] mem = new int[s];
	   mem[0] = Math.max(a.get(0).get(0), a.get(1).get(0));
	   if(mem.length == 1)
	        return mem[0];
		mem[1] = Math.max(a.get(0).get(1), a.get(1).get(1));
		mem[1] = Math.max(mem[0],mem[1]);
		if(mem.length == 2)
		    return Math.max(mem[0],mem[1]);
		for(int i=2; i<s; i++){
			mem[i] = 0;
			int with = Math.max(a.get(0).get(i), a.get(1).get(i)) + mem[i-2];
			int without = mem[i-1];
			mem[i] = Math.max(mem[i], Math.max(with, without));
		}
		return mem[mem.length-1];
	}
}
//	public int adjacent(ArrayList<ArrayList<Integer>> a) {
//	    int n = a.get(0).size();
//	    return solve(a, n-1);
//	}
//	public int solve(ArrayList<ArrayList<Integer>> a, int col){
//	   // for(int i=0;i<dp.length;i++)
//	   //     dp[i] = -1;
//	    if(col<0)
//	        return 0;
//	    if(dp[col] != 0)
//	        return dp[col];
//	    dp[col] = Math.max(Math.max(a.get(0).get(col), a.get(1).get(col)) + solve(a, col-2),
//	                       solve(a, col-1));
//	   return dp[col];
//	}
