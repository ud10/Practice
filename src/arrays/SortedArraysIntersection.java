package arrays;
import java.util.*;
public class SortedArraysIntersection {
	/*
	 * Given 2 sorted arrays, find all the elements which occur in both the arrays.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
	    int m = a.size();
	    int n = b.size();
	    int i = 0, j = 0;
	    ArrayList<Integer> res = new ArrayList<Integer>();
        while(i < m && j < n){
            if(a.get(i) < b.get(j))
                i++;
            else if(a.get(i) > b.get(j))
                j++;
            else{
              res.add(a.get(i));
              i++;j++;
            }
        }
        return res;
	}
}
