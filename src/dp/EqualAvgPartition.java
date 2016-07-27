package dp;
import java.util.*;
public class EqualAvgPartition {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(7);a.add(15);a.add(29);
		a.add(11);a.add(9);
		ArrayList<ArrayList<Integer>> res = avgset(a);
		for(int i = 0 ;i<res.size();i++){
			for(int j =0;j<res.get(i).size();j++){
				System.out.println(res.get(i).get(j));
			}	
			System.out.println("2nd");
		}
	}
	 public static <T> ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> a) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		 int n = a.size();
		 int sum = 0;
		 for(int i =0;i<n;i++){
			 sum += a.get(i);
		 }
		 //Collections.sort(a);
		 double avg = sum/n;
		 int subsetSize = n/2;
		 boolean[][][] dp = new boolean[subsetSize+1][n+1][sum+1];
		 for(int i = 0;i<=n;i++)
			 dp[0][i][0] = true;

		 for(int i = 1; i <= subsetSize; i++){
			 for(int j = 1; j < n; j++){
				 for(int k = 1; k <= sum; k++){
					 if(k >= a.get(j-1))
		                    dp[i][j][k] = dp[i-1][j-1][k - a.get(j-1)];
					 dp[i][j][k] = dp[i][j][k] || dp[i][j-1][k];
					 if(dp[i][j][k]){
						 double temp = k/i;
						 if(temp == avg){
							 System.out.println("Partition 1: " + k + " " + j);
						     System.out.println("Partition 1: " + (sum-k) + " " + (n-j));
							 ArrayList<Integer> x = new ArrayList<Integer>();
							 ArrayList<Integer> y = new ArrayList<Integer>();
//							 for(int p=0;p<i;p++){
//								 x.add(a.get(p));
//							 }
//							 for(int p=j;p<n;p++){
//								 y.add(a.get(p));
//							 }
							 //x.add(a.get(i-1)); y.add(a.get(n-i));
							 int id = 0;
							 while(x.size() != i && id <j){
								 x.add(a.get(id));id++;
							 }
							 id = 0;
							 while(y.size() != subsetSize - i && id < n){
								 x.add(a.get(id));id++;
							 }
							 Collections.sort(x);Collections.sort(y);
							 result.add(x);result.add(y);
							 return result;
						 }
					 }
				 }
	         }
	     }
		 return result;
	 }
}
