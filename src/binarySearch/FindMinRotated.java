/**
 * 
 */
package binarySearch;

/**
 * @author uditgupta
 * Aug 14, 2016 1:48:57 PM
 */
public class FindMinRotated {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	private static int findMin(int[] a){
		int l = 0, r = a.length - 1;
		while(l <= r){
			while(a[l] == a[r] && l!=r)
				l++;
			if(a[l] < a[r])
				return l;
			int m = (l+r)/2;
			
			if(a[l] <= a[m])
				l = m+1;
			else
				r = m;
		}	
		return -1;
	}
}
