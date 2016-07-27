package dp.kSumProblems;
import java.util.*;
public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * DP[n,1] = 1
		 * DP[n,2] = DP[n-2, 2] + DP[n-1,1] = n / 2
		 * DP[n,3] = DP[n-3, 3] + DP[n-1,2]
		 * DP[n,4] = DP[n-4, 4] + DP[n-1,3]
		 * 
		 * DP[n,k] = DP[n-k, k] + DP[n-1,k-1]
		 */

	}
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
	 
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int k = j + 1;
				int l = num.length - 1;
	 
				while (k < l) {
					int sum = num[i] + num[j] + num[k] + num[l];
	 
					if (sum > target) {
						l--;
					} else if (sum < target) {
						k++;
					} else if (sum == target) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[k]);
						temp.add(num[l]);
	 
						if (!hashSet.contains(temp)) {
							hashSet.add(temp);
							result.add(temp);
						}
	 
						k++;
						l--;
					}
				}
			}
		}
	 
		return result;
	}
}
