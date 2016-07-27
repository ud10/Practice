package greedy;
import java.util.*;
public class Bulbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);a.add(1);a.add(0);a.add(1);
		int n = bulbs(a);
		System.out.println(n);
	}
	public static int bulbs(ArrayList<Integer> a) {
		 int n = a.size();
	        int count = 0;
	        int state = 0;
	        for(int i=0;i<n;i++){
	            if(a.get(i)==state){
	                count++;
	                state = 1 - state;
	            }
	        }
	        return count;
	}
}
