package greedy;
import java.util.*;
public class DistributeCandy {
	/*
	 * There are N children standing in a line. Each child is assigned a rating value. You are giving candies to 
	 * these children subjected to the following requirements:
		1. Each child must have at least one candy.
		2. Children with a higher rating get more candies than their neighbors.
		What is the minimum candies you must give?
	 */
	public static void main(String[] args) {
		ArrayList<Integer> ratings = new ArrayList<Integer>();
		ratings.add(1);ratings.add(2);
		System.out.println(candy(ratings));
	}
	/**
	 * O(n), O(n)
	 * @param ratings
	 * @return minimum number of candies
	 */
	private static int candy(ArrayList<Integer> ratings){
		int result = 0;
		int n = ratings.size();
		int[] candies = new int[n];
		candies[0] = 1;
		for(int i = 1;i < n;i++){
			if(ratings.get(i) > ratings.get(i-1))
				candies[i] = candies[i-1] + 1;
			else 
				candies[i] = candies[i-1];
		}
		result = candies[n-1];
		for(int i = n-2;i>=0;i--){
			int cur = 1;
			if(ratings.get(i) > ratings.get(i+1)){
				cur = candies[i+1] + 1;
			}else if(ratings.get(i) == ratings.get(i+1) && candies[i] < candies[i+1]){
				cur = candies[i+1];
			}
			candies[i] = Math.max(candies[i], cur);
			
			result += candies[i];
		}
		return result;
	}
}
