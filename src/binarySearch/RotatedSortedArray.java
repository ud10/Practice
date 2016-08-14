/**
 * 
 */
package binarySearch;

/**
 * @author uditgupta
 * Aug 14, 2016 8:13:32 AM
 */
public class RotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//12345 --> 45123
		//12345 --> 34512
		int[] arr = {6,7,1,2,3,3,3,3,4,4,5,5,5};
		int[] arr1 = {2,2,2,2,3,2,2,2,2,2,2};
		int k = 3; 
		System.out.println(search(arr1, k));
	}
	private static int search(int[] arr, int k){
		int n = arr.length;
		int start = 0, end = n-1;
		while(start <= end){
			int mid = start + (end - start)/2;
			if(arr[mid] == k)
				return mid;
			//Bottom half is sorted
			if(arr[start] < arr[mid]){
				if(arr[start] <= k && k < arr[mid])
					end = mid-1;
				else
					start = mid+1;
			}
			//Upper half is sorted
			else if(arr[start] > arr[mid]){
				if(arr[mid] < k && k <= arr[end])
					start = mid+1;
				else
					end = mid-1;
			}
			else
				start++;
				
		}
		return -1;
		
	}
}
