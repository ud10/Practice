package dp.kSumProblems;
import java.util.*;
public class ThreeSumClosest {
	/*
	 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, 
	 * target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int threeSumClosest(ArrayList<Integer> a, int b) {
		int min = Integer.MAX_VALUE;
		int result = 0;
		Collections.sort(a);
		for(int i =0;i<a.size();i++){
			int j = i+1;
			int k = a.size()-1;
			while(j<k){
				int sum = a.get(i) + a.get(j) + a.get(k);
				int diff = Math.abs(sum - b);
				if(diff == 0)
					return sum;
				if(diff < min){
					result = sum;
					min = diff;
				}
				if(sum < b)
					j++;
				else 
					k--;
			}
		}
		return result;
	}
}
