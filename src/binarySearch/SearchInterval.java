package binarySearch;
import java.util.*;
public class SearchInterval {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(5);al.add(7);al.add(7);al.add(8);al.add(8);al.add(10);
		//int[] array = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10 };
		
		List<Integer> result = searchRange(al, 8);
		System.out.println(result.get(0));
		System.out.println(result.get(1));
	}
	public static ArrayList<Integer> searchRange(final ArrayList<Integer> a, int b) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int l = -1, r=-1;
		int n = a.size();
		int i=0,j=n-1;
		while(i<=j){
		    if(a.get(i) == a.get(j) && a.get(i) == b){
		        l = i; r = j;
		    }
			int mid = (i+j)/2;
			if(a.get(mid) == b){
				l = mid; r = mid;
				int x = mid;
				while(x > i && a.get(x) == a.get(x-1)){
				    x--; l = x;
				}
				int y = mid;
				while(y < j && a.get(y) == a.get(y+1)){
				    y++; r = y;
				}
			}
			else if(a.get(mid) < b){
				i = mid+1;
			}
			else j = mid-1;
		}
		res.add(l);res.add(r);
		return res;
	}
}
