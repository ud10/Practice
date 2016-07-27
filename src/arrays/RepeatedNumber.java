package arrays;
import java.util.*;
public class RepeatedNumber {

	public static void main(String[] args) {

	}
	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
	    ArrayList<Integer> al = new ArrayList<Integer>();
	    int x = a.get(0);
	    for(int i =1;i<a.size();i++){
	        x = x^a.get(i);
	    }
	    int miss = 0;
	    for(int i = 1;i<=a.size();i++){
	      miss = x^i;   
	    }
	    int rep = 0;
	    for(int i = 1;i<=a.size();i++){
	      rep = a.get(i-1)^i;   
	    }
	    al.add(miss);al.add(rep);
	    return al;
	}
}
