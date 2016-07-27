package dp;

import java.util.*;
public class RainWater {
	/*
	 * An element of array can store water if there are higher bars on left and right. We can find amount of water 
	 * to be stored in every element by finding the heights of bars on left and right sides. The idea is to compute 
	 * amount of water that can be stored in every element of array. 
	 */
	public static void main(String args[]){
		 List<Integer> a = new ArrayList<Integer>();
		 a.add(2);a.add(1);a.add(0);a.add(1);
		 a.add(3);a.add(2);a.add(1);a.add(2);
		 int x = trap(a);
		 System.out.println(x);
	}
	public static int trap(final List<Integer> a) {
	    int result = 0;
	    if(a.size() < 2) 
	        return result;
	    List<Integer> l = new ArrayList<Integer>(a.size());
	    List<Integer> r = new ArrayList<Integer>(a.size());
	    
	    int max = a.get(0);
	    l.add(max);
	    for(int i=1;i<a.size();i++){
	        if(a.get(i) < max){
	            l.add(max);
	        }else{
	            max = a.get(i);
	            l.add(max);
	        }
	    }
	    max = a.get(a.size()-1);
	    for(int i=0;i<r.size();i++){
	    	r.add(max);
	    }
	    r.add(a.size()-2, max);
	    for(int i=a.size()-2;i>=0;i--){
	        if(a.get(i) < max){
	            r.add(i,max);
	        }else{
	            max = a.get(i);
	            r.add(i,max);
	        }
	    }
	    
	    for(int i=0;i<a.size();i++){
	        result += Math.min(l.get(i), r.get(i)) - a.get(i);
	    }
	    
	    return result;
	}
}
