package arrays;
import java.util.ArrayList;
import java.util.Collections;
public class AddOneToNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 0, 6, 0, 6, 4, 8, 8, 1 
		//1, 9, 9, 9, 9, 9, 9
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0);a.add(1); a.add(9); a.add(9); a.add(9); a.add(9); a.add(9); a.add(9);
		ArrayList<Integer> b = plusOne(a);
		for(int i = 0;i<b.size();i++){
			System.out.println(b.get(i));
		}
	}
	public static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		   int n = a.size();
		    if(n > 0){
		        int last = a.get(n-1);
	    	    if(last < 9)
	    	    	a.set(n-1, last+1);
	    	    else{
	    	    	Collections.reverse(a);
	    	    	int c = 1;
	    	    	for(int i = 0; i< n; i++){
	    	    		int cur = a.get(i) + c;
	    	    		if(cur > 9){
	    	    			a.set(i, cur%10);
	    	    		}else{
	    	    			a.set(i, cur);
	    	    		}
	    	    		c = cur/10;
	    	    	}
	    	    	if(c != 0){
	    	    		a.add(c);
	    	    	}
	    	    	Collections.reverse(a);
	    	    }
		    }
		    int id = 0;
		    while(a.get(id) == 0 && id < a.size()){
		    	a.remove(id);
		    	id++;
		    }
			return a;
	}

}
