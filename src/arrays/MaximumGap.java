package arrays;

import java.util.List;
import java.util.*;
class Bucket{
    int low;
    int high;
    public Bucket(){
        low = -1;
        high = -1; 
    }
}

public class MaximumGap {
	/*
	 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
	 * Try to solve it in linear time/space.
	 */
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);a.add(10);a.add(5);
		System.out.println(maximumGap(a));
	}
	public static int maximumGap(final List<Integer> a) {
		int n = a.size();
		if(n < 2){
	        return 0;
	    }
		int[] num = new int[n];
		for(int i=0;i<n;i++){
			num[i] = a.get(i);
		}
	    int max = num[0];
	    int min = num[0];
	    for(int i=1; i<n; i++){
	        max = Math.max(max, num[i]);
	        min = Math.min(min, num[i]);
	    }
	 
	    // initialize an array of buckets
	    Bucket[] buckets = new Bucket[n+1]; //project to (0 - n)
	    for(int i=0; i<buckets.length; i++){
	        buckets[i] = new Bucket();
	    }
	 
	    double interval = (double) n/ (max - min);
	    System.out.println(interval);
	    //distribute every number to a bucket array
	    for(int i=0; i<n; i++){
	        int index = (int) ((num[i] - min) * interval);
	        System.out.println(index);
	        if(buckets[index].low == -1){
	            buckets[index].low = num[i];
	            buckets[index].high = num[i];
	        }else{
	            buckets[index].low = Math.min(buckets[index].low, num[i]);
	            buckets[index].high = Math.max(buckets[index].high, num[i]);
	        }
	    }
	 
	    //scan buckets to find maximum gap
	    int result = 0;
	    int prev = buckets[0].high;
	    for(int i=1; i<buckets.length; i++){
	        if(buckets[i].low != -1){
	            result = Math.max(result, buckets[i].low-prev);
	            prev = buckets[i].high;
	        }
	    }
	    return result;
	}
/**
 * !!!!!Better Explained!!!!!
 * 
 * public int maximumGap(int[] num) {
    if (num == null || num.length < 2)
        return 0;
    // get the max and min value of the array
    int min = num[0];
    int max = num[0];
    for (int i:num) {
        min = Math.min(min, i);
        max = Math.max(max, i);
    }
    // the minimum possibale gap, ceiling of the integer division
    int gap = (int)Math.ceil((double)(max - min)/(num.length - 1));
    int[] bucketsMIN = new int[num.length - 1]; // store the min value in that bucket
    int[] bucketsMAX = new int[num.length - 1]; // store the max value in that bucket
    Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
    Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
    // put numbers into buckets
    for (int i:num) {
        if (i == min || i == max)
            continue;
        int idx = (i - min) / gap; // index of the right position in the buckets
        bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
        bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
    }
    // scan the buckets for the max gap
    int maxGap = Integer.MIN_VALUE;
    int previous = min;
    for (int i = 0; i < num.length - 1; i++) {
        if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
            // empty bucket
            continue;
        // min value minus the previous value is the current gap
        maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
        // update previous bucket value
        previous = bucketsMAX[i];
    }
    maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
    return maxGap;
}
 */
}
