package dp;
import java.util.*;
public class LIS {
	/*
	 * Find the length of longest increasing subsequence of a given sequence / array.
	 */
	public static void main(String[] args) {

	}
	public int lis(ArrayList<Integer> a){
		int l = a.size();
		int[] dp = new int[l];
		for(int i=0;i<l;i++)
			dp[i]=1;
		for(int i=1;i<l;i++){
			for(int j=0;j<i;j++){
				if(a.get(i)>a.get(j) && dp[i] < dp[j]+1){
					dp[i] = dp[j] +1;
				}
			}
		}
		int max = 0;
		for(int i=0;i<l;i++){
			if(max < dp[i])
				max = dp[i];
		}
		return max;
	}
}
