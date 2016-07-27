package arrays;
import java.util.*;
public class RemoveDuplicatesI {

	public static void main(String[] args){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.clear();
		a.add(5000);a.add(5000);a.add(5000);
		System.out.println(removeDuplicates(a));
	}
	public static int removeDuplicates(ArrayList<Integer> a) {
	    if (a.size() < 2)
		    return a.size();	    
    	int j = 0;
    	int i = 1;
    	while(i < a.size()) {
    		if(a.get(i).intValue() == a.get(j).intValue()) {
    			i++;
    		} else {
    			j++;
    			a.add(j,a.get(i));
    			i++;
    		}
    	}
    	return j + 1;
	}
}
