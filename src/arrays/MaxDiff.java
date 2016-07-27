/**
 * 
 */
package arrays;

import java.util.Arrays;

public class MaxDiff {

	public static void main(String[] args) {
		//80, 2, 6, 3, 100
		int[] arr = new int[5];
		//
		Arrays.sort(arr);
		arr[0] = 80; arr[1] = 2; arr[2] = 2; arr[3] = 2; arr[4] = 80;
		System.out.println(getMinimumUniqueSum(arr));
		
	}
	static int getMinimumUniqueSum(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int sum = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i-1] != arr[i]){
                sum += arr[i];
            }else{
                arr[i] = arr[i] + 1;
                sum += arr[i];
            }
        }
        return sum;
    }
}
