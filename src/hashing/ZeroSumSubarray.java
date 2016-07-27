package hashing;
import java.util.*;
public class ZeroSumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<Integer> lszero(ArrayList<Integer> a) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		int curr_sum = a.get(0), start = 0, i;
		int sum = 0;
		int n = a.size();
	    /* Add elements one by one to curr_sum and if the curr_sum exceeds the
	       sum, then remove starting element */
	    for (i = 1; i <= n; i++)
	    {
	        // If curr_sum exceeds the sum, then remove the starting elements
	        while (curr_sum > sum && start < i-1)
	        {
	            curr_sum = curr_sum - a.get(start);
	            start++;
	        }
	 
	        // If curr_sum becomes equal to sum, then return true
	        if (curr_sum == sum)
	        {
	        	for(int j=start;j<=i-1;j++){
	        		res.add(a.get(j));
	        	}
	            return res;
	        }
	 
	        // Add this element to curr_sum
	        if (i < n)
	          curr_sum = curr_sum + a.get(i);
	    }
	    return res;
	}
}
